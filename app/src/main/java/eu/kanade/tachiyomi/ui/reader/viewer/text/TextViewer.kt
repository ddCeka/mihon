package eu.kanade.tachiyomi.ui.reader.viewer.text

import android.content.Context
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.AndroidUiDispatcher
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import eu.kanade.tachiyomi.ui.reader.ReaderActivity
import eu.kanade.tachiyomi.ui.reader.loader.TextPageLoader
import eu.kanade.tachiyomi.ui.reader.model.ChapterTransition
import eu.kanade.tachiyomi.ui.reader.model.ReaderChapter
import eu.kanade.tachiyomi.ui.reader.model.ReaderPage
import eu.kanade.tachiyomi.ui.reader.model.TextReaderPage
import eu.kanade.tachiyomi.ui.reader.model.ViewerChapters
import eu.kanade.tachiyomi.ui.reader.setting.ReaderPreferences
import eu.kanade.tachiyomi.ui.reader.viewer.ReaderThemedContent
import eu.kanade.tachiyomi.ui.reader.viewer.ReaderTransitionPage
import eu.kanade.tachiyomi.ui.reader.viewer.Viewer
import eu.kanade.tachiyomi.ui.reader.viewer.transitionDownloadState
import eu.kanade.tachiyomi.util.system.createReaderThemeContext
import eu.kanade.tachiyomi.util.system.readerBackgroundColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import mihon.app.di.appGraph
import mihon.core.archive.book.BookBlock
import tachiyomi.presentation.core.util.collectAsState
import kotlin.math.min

/**
 * Implementation of a [Viewer] that lays out the text of a text book as one scrolling column.
 */
class TextViewer(val activity: ReaderActivity) : Viewer {

    private val graph by lazy { activity.appGraph }
    private val readerPreferences by lazy { graph.readerPreferences }
    private val settingsViewModel = activity.settingsViewModel

    // Animated scrolls need a frame clock, which MainScope does not carry.
    private val scope = CoroutineScope(AndroidUiDispatcher.Main)
    private val listState = LazyListState()

    private var layout by mutableStateOf<TextLayout?>(null)

    /** The chapter whose start was last scrolled to, so that reloading the same chapter keeps the position. */
    private var shownChapter: ReaderChapter? = null

    @Composable
    override fun Content(modifier: Modifier) {
        val current = layout ?: return
        val general by settingsViewModel.general.collectAsState()
        val fontSize by readerPreferences.textFontSize.collectAsState()
        val lineSpacing by readerPreferences.textLineSpacing.collectAsState()
        val sideMargin by readerPreferences.textSideMargin.collectAsState()
        val font by readerPreferences.textFont.collectAsState()
        val justify by readerPreferences.textJustify.collectAsState()

        // Text is drawn over the reader background, so it takes the colour that contrasts with it.
        val background = remember(general.theme) { Color(activity.readerBackgroundColor(general.theme)) }
        val settings = TextSettings(
            fontSize = fontSize,
            lineSpacing = lineSpacing,
            family = font.toFontFamily(),
            justify = justify,
            color = if (background.luminance() < 0.5f) Color.Black else Color.White,
        )
        val themedContext = remember(general.theme) { activity.createReaderThemeContext() }

        val page by remember(current) {
            derivedStateOf {
                when {
                    listState.layoutInfo.visibleItemsInfo.isEmpty() -> null
                    !listState.canScrollForward -> current.pages.lastOrNull()
                    else -> current.rows.getOrNull(listState.firstVisibleItemIndex)?.let {
                        current.pages[it.pageIndex]
                    }
                }
            }
        }
        LaunchedEffect(page) {
            page?.let { activity.onPageSelected(it) }
        }

        var viewportSize by remember { mutableStateOf(IntSize.Zero) }
        LazyColumn(
            state = listState,
            modifier = modifier
                .onSizeChanged { viewportSize = it }
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        activity.onViewerTap(
                            Offset(offset.x / viewportSize.width, offset.y / viewportSize.height),
                        )
                    }
                },
            contentPadding = PaddingValues(horizontal = sideMargin.dp, vertical = 16.dp),
        ) {
            itemsIndexed(current.rows) { _, row ->
                TextBlockItem(row.block, settings, current.loader)
            }
            item {
                TransitionItem(current.chapters, themedContext)
            }
        }
    }

    @Composable
    private fun TransitionItem(chapters: ViewerChapters, themedContext: Context) {
        val transition = remember(chapters) {
            ChapterTransition.Next(chapters.currChapter, chapters.nextChapter)
        }
        val downloadState = remember(transition) {
            graph.downloadManager.transitionDownloadState(
                transition,
                activity.viewModel.manga,
                activity.viewModel.source,
            )
        }
        LaunchedEffect(downloadState) { downloadState?.checkDisk() }
        ReaderThemedContent(themedContext) {
            ReaderTransitionPage(
                transition = transition,
                downloadState = downloadState,
                onRetry = activity::requestPreloadChapter,
                onButtonPressChange = {},
                statusPadding = PaddingValues(vertical = 16.dp),
            )
        }
    }

    override fun destroy() {
        scope.cancel()
    }

    override fun setChapters(chapters: ViewerChapters) {
        val current = chapters.currChapter
        val pages = current.pages.orEmpty().filterIsInstance<TextReaderPage>()
        val rows = pages.flatMapIndexed { pageIndex, page -> page.blocks.map { TextRow(pageIndex, it) } }
        layout = TextLayout(chapters, pages, rows, current.pageLoader as? TextPageLoader)

        if (shownChapter !== current) {
            shownChapter = current
            scrollToPage(min(current.requestedPage, pages.lastIndex))
        }
    }

    override fun moveToPage(page: ReaderPage) {
        val pageIndex = layout?.pages?.indexOfFirst { it === page } ?: -1
        if (pageIndex != -1) scrollToPage(pageIndex)
    }

    override fun moveForward() {
        if (!listState.canScrollForward) {
            if (layout?.chapters?.nextChapter != null) activity.loadNextChapter()
            return
        }
        scrollByPage(forward = true)
    }

    override fun moveBackward() {
        if (!listState.canScrollBackward) {
            if (layout?.chapters?.prevChapter != null) activity.loadPreviousChapter()
            return
        }
        scrollByPage(forward = false)
    }

    private fun scrollToPage(pageIndex: Int) {
        val row = layout?.rows?.indexOfFirst { it.pageIndex == pageIndex } ?: -1
        // Not a suspending scroll: the position has to be in place before the first page is reported as read.
        if (row != -1) listState.requestScrollToItem(row)
    }

    private fun scrollByPage(forward: Boolean) {
        val distance = listState.layoutInfo.viewportSize.height * PAGE_SCROLL_FRACTION
        val delta = if (forward) distance else -distance
        scope.launch {
            if (settingsViewModel.general.value.usePageTransitions) {
                listState.animateScrollBy(delta)
            } else {
                listState.scrollBy(delta)
            }
        }
    }
}

private class TextLayout(
    val chapters: ViewerChapters,
    val pages: List<TextReaderPage>,
    val rows: List<TextRow>,
    val loader: TextPageLoader?,
)

/** One lazy item: a [block] of the page at [pageIndex] within the chapter. */
private class TextRow(val pageIndex: Int, val block: BookBlock)

private fun ReaderPreferences.TextFont.toFontFamily(): FontFamily = when (this) {
    ReaderPreferences.TextFont.SANS -> FontFamily.SansSerif
    ReaderPreferences.TextFont.SERIF -> FontFamily.Serif
    ReaderPreferences.TextFont.MONO -> FontFamily.Monospace
}

private const val PAGE_SCROLL_FRACTION = 0.85f
