package eu.kanade.tachiyomi.ui.reader.viewer.webtoon

import android.graphics.ColorFilter
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.animation.LinearInterpolator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.asAndroidColorFilter
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.WebtoonLayoutManager
import eu.kanade.tachiyomi.ui.reader.ReaderActivity
import eu.kanade.tachiyomi.ui.reader.model.ChapterTransition
import eu.kanade.tachiyomi.ui.reader.model.ReaderPage
import eu.kanade.tachiyomi.ui.reader.model.ViewerChapters
import eu.kanade.tachiyomi.ui.reader.setting.GeneralSettings
import eu.kanade.tachiyomi.ui.reader.viewer.LocalPageColorFilter
import eu.kanade.tachiyomi.ui.reader.viewer.LongStripSettings
import eu.kanade.tachiyomi.ui.reader.viewer.ReaderPageImageView
import eu.kanade.tachiyomi.ui.reader.viewer.Viewer
import eu.kanade.tachiyomi.ui.reader.viewer.collectChanges
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import mihon.app.di.appGraph
import tachiyomi.core.common.util.system.logcat
import java.util.Collections
import java.util.WeakHashMap
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Implementation of a [Viewer] to display pages with a [RecyclerView].
 */
class WebtoonViewer(val activity: ReaderActivity, val isContinuous: Boolean = true) : Viewer {

    val graph by lazy { activity.appGraph }
    val downloadManager by lazy { graph.downloadManager }
    val readerPreferences by lazy { graph.readerPreferences }

    private val scope = MainScope()

    /**
     * Recycler view used by this viewer.
     */
    val recycler = WebtoonRecyclerView(activity)

    /**
     * Frame containing the recycler view.
     */
    private val frame = WebtoonFrame(activity)

    /**
     * Distance to scroll when the user taps on one side of the recycler view.
     */
    private val scrollDistance = activity.resources.displayMetrics.heightPixels * 3 / 4

    /**
     * Layout manager of the recycler view.
     */
    private val layoutManager = WebtoonLayoutManager(activity, scrollDistance)

    private val settingsViewModel = activity.settingsViewModel

    /**
     * Settings every long strip viewer uses, like crop image borders.
     */
    val longStrip: LongStripSettings
        get() = settingsViewModel.longStrip.value

    /**
     * Settings only the webtoon viewers use, like side padding or tap zones.
     */
    val simpleLongStrip: SimpleLongStripSettings
        get() = settingsViewModel.simpleLongStrip.value

    /**
     * Settings shared by every viewer, like allow taps or page transitions.
     */
    val general: GeneralSettings
        get() = settingsViewModel.general.value

    private val webtoonItems = WebtoonItems()

    /**
     * Adapter of the recycler view.
     */
    private val adapter = WebtoonAdapter(this, webtoonItems)

    private val tracker = WebtoonPageTracker(
        activity,
        webtoonItems,
        readerPreferences.readerHideThreshold.get().threshold,
    )

    private var pendingPageOffset: Pair<ReaderPage, Int>? = null

    init {
        recycler.sidePaddingPercent = simpleLongStrip.page.sidePadding
        recycler.setItemViewCacheSize(RECYCLER_VIEW_CACHE_SIZE)
        recycler.isVisible = false // Don't let the recycler layout yet
        recycler.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        recycler.isFocusable = false
        recycler.itemAnimator = null
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    onScrolled()
                    val firstVisible = layoutManager.findFirstVisibleItemPosition()
                    val lastEndVisible = layoutManager.findLastEndVisibleItemPosition()
                    tracker.onScrolledBy(dy.toFloat(), firstVisible, lastEndVisible)
                    val page = adapter.items.getOrNull(lastEndVisible) as? ReaderPage
                    if (page != null) {
                        activity.onPageScrolled(page, pageOffset(page))
                    }
                }
            },
        )
        recycler.tapListener = { event ->
            val viewPosition = IntArray(2)
            recycler.getLocationOnScreen(viewPosition)
            val viewPositionRelativeToWindow = IntArray(2)
            recycler.getLocationInWindow(viewPositionRelativeToWindow)
            val pos = Offset(
                (event.rawX - viewPosition[0] + viewPositionRelativeToWindow[0]) / recycler.width,
                (event.rawY - viewPosition[1] + viewPositionRelativeToWindow[1]) / recycler.originalHeight,
            )
            activity.onViewerTap(pos)
        }
        recycler.longTapListener = f@{ event ->
            if (activity.viewModel.state.value.menuVisible || general.longTapEnabled) {
                val child = recycler.findChildViewUnder(event.x, event.y)
                if (child != null) {
                    val position = recycler.getChildAdapterPosition(child)
                    val item = adapter.items.getOrNull(position)
                    if (item is ReaderPage) {
                        activity.onPageLongTap(item)
                        return@f true
                    }
                }
            }
            false
        }

        settingsViewModel.general.collectChanges(scope) { old, new ->
            if (old != null && old.theme != new.theme) {
                ActivityCompat.recreate(activity)
            }
            if (old != null && old.highQualityUpscaling != new.highQualityUpscaling) {
                refreshAdapter()
            }
        }
        settingsViewModel.longStrip.collectChanges(scope) { old, new ->
            if (old != null && old.cropBorders != new.cropBorders) {
                refreshAdapter()
            }
            if (old?.zoomOutDisabled != new.zoomOutDisabled) {
                frame.zoomOutDisabled = new.zoomOutDisabled
            }
        }
        settingsViewModel.simpleLongStrip.collectChanges(scope) { old, new ->
            if (old != null && old.page != new.page) {
                recycler.sidePaddingPercent = new.page.sidePadding
                refreshAdapter()
            }
            if (old?.doubleTapZoom != new.doubleTapZoom) {
                frame.doubleTapZoom = new.doubleTapZoom
            }
        }

        frame.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        frame.descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS
        frame.addView(recycler)
    }

    /** The page images' colours, for pages bound later - see [LocalPageColorFilter]. */
    var pageColorFilter: ColorFilter? = null
        private set

    /** Every page view made, as the recycler's cached ones are neither children nor always bound again. */
    private val pageViews = Collections.newSetFromMap(WeakHashMap<ReaderPageImageView, Boolean>())

    fun onPageViewCreated(view: ReaderPageImageView) {
        pageViews += view
    }

    @Composable
    override fun Content(modifier: Modifier) {
        val filter = LocalPageColorFilter.current
        val pageFilter = remember(filter) { filter?.asAndroidColorFilter() }
        SideEffect {
            pageColorFilter = pageFilter
            pageViews.forEach { it.pageColorFilter = pageFilter }
        }
        AndroidView(factory = { frame }, modifier = modifier)
    }

    /**
     * Destroys this viewer. Called when leaving the reader or swapping viewers.
     */
    override fun destroy() {
        super.destroy()
        scope.cancel()
    }

    /**
     * Tells this viewer to set the given [chapters] as active.
     */
    override fun setChapters(chapters: ViewerChapters) {
        val forceTransition = general.alwaysShowChapterTransition
        tracker.reset()
        adapter.setChapters(chapters, forceTransition)

        if (recycler.isGone) {
            logcat { "Recycler first layout" }
            val pages = chapters.currChapter.pages ?: return
            moveToPage(
                pages[min(chapters.currChapter.requestedPage, pages.lastIndex)],
                chapters.currChapter.requestedPageOffset,
            )
            recycler.isVisible = true
        }
    }

    /**
     * Tells this viewer to move to the given [page].
     */
    override fun moveToPage(page: ReaderPage) {
        moveToPage(page, 0)
    }

    private fun moveToPage(page: ReaderPage, pageOffset: Int) {
        val position = adapter.items.indexOf(page)
        if (position != -1) {
            pendingPageOffset = page to pageOffset
            layoutManager.scrollToPositionWithOffset(position, 0)
            restorePendingPageOffset()
            if (layoutManager.findLastEndVisibleItemPosition() == -1) {
                onScrolled(pos = position)
            }
        } else {
            logcat { "Page $page not found in adapter" }
        }
    }

    private fun onScrolled(pos: Int? = null) {
        tracker.onScrolled(pos ?: layoutManager.findLastEndVisibleItemPosition())
    }

    fun onPageDecoded(page: ReaderPage) {
        if (pendingPageOffset?.first == page) {
            restorePendingPageOffset()
        }
    }

    private fun restorePendingPageOffset() {
        val (page, pageOffset) = pendingPageOffset ?: return
        val position = adapter.items.indexOf(page)
        val view = layoutManager.findViewByPosition(position) ?: return
        val maxOffset = (view.height - recycler.height).coerceAtLeast(0)
        val offset = (maxOffset * pageOffset / PAGE_OFFSET_MAX.toFloat()).roundToInt()
        layoutManager.scrollToPositionWithOffset(position, -offset)
        pendingPageOffset = null
    }

    private fun pageOffset(page: ReaderPage): Int {
        val position = adapter.items.indexOf(page)
        val view = layoutManager.findViewByPosition(position) ?: return 0
        val maxOffset = (view.height - recycler.height).coerceAtLeast(0)
        if (maxOffset == 0) return 0
        return ((-view.top).coerceIn(0, maxOffset) * PAGE_OFFSET_MAX / maxOffset.toFloat()).roundToInt()
    }

    /**
     * Scrolls up by [scrollDistance].
     */
    override fun moveBackward() {
        if (general.usePageTransitions) {
            recycler.smoothScrollBy(0, -scrollDistance)
        } else {
            recycler.scrollBy(0, -scrollDistance)
        }
    }

    /**
     * Scrolls one screen over a period of time.
     */
    fun linearScroll(duration: Duration) {
        recycler.smoothScrollBy(
            0,
            activity.resources.displayMetrics.heightPixels,
            LinearInterpolator(),
            duration.inWholeMilliseconds.toInt(),
        )
    }

    /**
     * Stops any ongoing smooth scroll animation immediately.
     */
    fun stopScroll() {
        recycler.stopScroll()
    }

    /**
     * Scrolls down by [scrollDistance].
     */
    override fun moveForward() {
        if (general.usePageTransitions) {
            recycler.smoothScrollBy(0, scrollDistance)
        } else {
            recycler.scrollBy(0, scrollDistance)
        }
    }

    /**
     * Notifies adapter of changes around the current page to trigger a relayout in the recycler.
     * Used when an image configuration is changed.
     */
    private fun refreshAdapter() {
        val position = layoutManager.findLastEndVisibleItemPosition()
        adapter.refresh()
        adapter.notifyItemRangeChanged(
            max(0, position - 3),
            min(position + 3, adapter.itemCount - 1),
        )
    }
}

// Double the cache size to reduce rebinds/recycles incurred by the extra layout space on scroll direction changes
private const val RECYCLER_VIEW_CACHE_SIZE = 4
private const val PAGE_OFFSET_MAX = 1000
