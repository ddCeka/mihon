package eu.kanade.tachiyomi.data.download

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import dev.zacsweers.metro.Inject
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.core.security.SecurityPreferences
import eu.kanade.tachiyomi.data.download.model.Download
import eu.kanade.tachiyomi.data.notification.NotificationHandler
import eu.kanade.tachiyomi.data.notification.NotificationReceiver
import eu.kanade.tachiyomi.data.notification.Notifications
import eu.kanade.tachiyomi.util.lang.chop
import eu.kanade.tachiyomi.util.system.cancelNotification
import eu.kanade.tachiyomi.util.system.notificationBuilder
import eu.kanade.tachiyomi.util.system.notify
import tachiyomi.core.common.i18n.stringResource
import tachiyomi.i18n.MR
import java.util.regex.Pattern
import mihon.icons.materialsymbols.R as MaterialSymbolsR

/**
 * DownloadNotifier is used to show notifications when downloading one or multiple chapters.
 *
 * @param context context of application
 */
@Inject
class DownloadNotifier(
    private val context: Context,
    private val preferences: SecurityPreferences,
) {

    private val progressNotificationBuilder by lazy {
        context.notificationBuilder(Notifications.CHANNEL_DOWNLOADER_PROGRESS) {
            setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
            setAutoCancel(false)
            setOnlyAlertOnce(true)
        }
    }

    /**
     * State for grouped progress notifications:
     * - one notification for ongoing download batch
     * - one notification per active chapter
     */
    private val childNotificationIds = mutableMapOf<Long, Int>()
    private val activeDownloads = LinkedHashMap<Long, Download>()
    private val renderLock = Any()

    /**
     * Updates the current set of active downloads and reconciles the notification tree.
     * TODO: this is pretty fragile and may not work on some OEM
     */
    @Synchronized
    fun setActiveDownloads(downloads: List<Download>) {
        val next = downloads.associateBy { it.chapter.id }
        val previous = activeDownloads.toMap()

        // Remove stale notifications
        (previous.keys - next.keys).forEach { chapterId ->
            childNotificationIds[chapterId]?.let { childId ->
                context.cancelNotification(childId)
            }
            childNotificationIds.remove(chapterId)
            activeDownloads.remove(chapterId)
        }

        // Update existing and add new
        next.forEach { (chapterId, download) ->
            activeDownloads[chapterId] = download
            renderChildNotification(download)
        }

        val active = activeDownloads.values.toList()
        if (active.isEmpty()) {
            dismissProgress()
            return
        }

        renderSummaryNotification(active)
    }

    private fun makeStableChildNotificationId(chapterId: Long): Int {
        return childNotificationIds.getOrPut(chapterId) {
            val base = chapterId.hashCode() and Int.MAX_VALUE
            val id = Notifications.CHILD_PROGRESS_NOTIFICATION_OFFSET + (base % 100000)
            if (id == Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS) id + 1 else id
        }
    }

    private fun renderSummaryNotification(downloads: List<Download>) {
        val count = downloads.size
        val title = context.stringResource(MR.strings.download_notifier_downloader_title)
        val text = when {
            count <= 1 -> context.stringResource(
                MR.strings.chapter_downloading_progress,
                downloads.first().downloadedImages,
                downloads.first().pages?.size ?: 1,
            )
            else -> "Downloading $count chapters"
        }

        context.notify(
            Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS,
            Notifications.CHANNEL_DOWNLOADER_PROGRESS,
        ) {
            setGroupSummary(true)
            setGroup(Notifications.GROUP_DOWNLOADER_PROGRESS)
            setSmallIcon(android.R.drawable.stat_sys_download)
            setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
            setAutoCancel(false)
            setOnlyAlertOnce(true)
            setOngoing(true)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
            setContentTitle(title)
            setContentText(text)
            clearActions()
            addAction(
                MaterialSymbolsR.drawable.rounded_filled_pause,
                context.stringResource(MR.strings.action_pause),
                NotificationReceiver.pauseDownloadsPendingBroadcast(context),
            )
            addAction(
                MaterialSymbolsR.drawable.rounded_book,
                context.stringResource(MR.strings.action_show_manga),
                NotificationReceiver.openEntryPendingActivity(context, downloads.first().manga.id),
            )
        }
    }

    private fun renderChildNotification(download: Download) {
        val chapterId = download.chapter.id
        val childId = makeStableChildNotificationId(chapterId)
        val totalPages = download.pages?.size ?: 0
        val progress = download.downloadedImages.coerceAtMost(totalPages)

        val title = if (download.manga.title.isNotBlank()) {
            val cleanedChapter = download.chapter.name
            "${download.manga.title.chop(18)} - ${cleanedChapter.chop(18)}"
        } else {
            download.chapter.name.chop(30)
        }

        context.notify(
            childId,
            Notifications.CHANNEL_DOWNLOADER_PROGRESS,
        ) {
            setGroupSummary(false)
            setGroup(Notifications.GROUP_DOWNLOADER_PROGRESS)
            setSmallIcon(android.R.drawable.stat_sys_download)
            setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
            setAutoCancel(false)
            setOnlyAlertOnce(true)
            setOngoing(true)
            setContentTitle(title)
            setContentText(
                context.stringResource(
                    MR.strings.chapter_downloading_progress,
                    progress,
                    totalPages.coerceAtLeast(1),
                ),
            )
            setProgress(totalPages.coerceAtLeast(1), progress, false)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
        }
    }

    /**
     * Status of download. Used for correct notification icon.
     */
    private var isDownloading = false

    /**
     * Shows a notification from this builder.
     *
     * @param id the id of the notification.
     */
    private fun NotificationCompat.Builder.show(id: Int) {
        context.notify(id, build())
    }

    /**
     * Dismiss the downloader's notification. Downloader error notifications use a different id, so
     * those can only be dismissed by the user.
     */
    fun dismissProgress() {
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS)
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
        childNotificationIds.values.forEach { childId ->
            context.cancelNotification(childId)
        }
        childNotificationIds.clear()
        activeDownloads.clear()
    }

    private var lastProgressNotificationTime = 0L

    /**
     * Called when download progress changes.
     *
     * Called for every downloaded page from parallel downloads, so it shares the builder under a lock and skips
     * updates that come faster than the system would show them anyway.
     *
     * @param download download object containing download information.
     */
    @Synchronized
    fun onProgressChange(download: Download) {
        // Reconcile the notification set instead of overwriting a single builder.
        val allActive = activeDownloads.values.toList()
        if (allActive.isNotEmpty()) {
            renderSummaryNotification(allActive)
            renderChildNotification(download)
            return
        }

        val now = SystemClock.elapsedRealtime()
        val isComplete = download.downloadedImages == download.pages?.size
        if (!isComplete && now - lastProgressNotificationTime < PROGRESS_NOTIFICATION_INTERVAL_MS) return
        lastProgressNotificationTime = now

        with(progressNotificationBuilder) {
            if (!isDownloading) {
                context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
                setSmallIcon(android.R.drawable.stat_sys_download)
                clearActions()
                // Open download manager when clicked
                setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
                isDownloading = true
                // Pause action
                addAction(
                    MaterialSymbolsR.drawable.rounded_filled_pause,
                    context.stringResource(MR.strings.action_pause),
                    NotificationReceiver.pauseDownloadsPendingBroadcast(context),
                )
                addAction(
                    MaterialSymbolsR.drawable.rounded_book,
                    context.stringResource(MR.strings.action_show_manga),
                    NotificationReceiver.openEntryPendingActivity(context, download.manga.id),
                )
            }

            val downloadingProgressText = context.stringResource(
                MR.strings.chapter_downloading_progress,
                download.downloadedImages,
                download.pages!!.size,
            )

            if (preferences.hideNotificationContent.get()) {
                setContentTitle(downloadingProgressText)
                setContentText(null)
            } else {
                val title = download.manga.title.chop(15)
                val quotedTitle = Pattern.quote(title)
                val chapter = download.chapter.name.replaceFirst(
                    "$quotedTitle[\\s]*[-]*[\\s]*".toRegex(RegexOption.IGNORE_CASE),
                    "",
                )
                setContentTitle("$title - $chapter".chop(30))
                setContentText(downloadingProgressText)
            }

            setProgress(download.pages!!.size, download.downloadedImages, false)
            setOngoing(true)

            show(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS)
        }
    }

    /**
     * Show notification when download is paused.
     */
    fun onPaused() {
        // The progress id belongs to the download worker's foreground service, which takes the
        // notification with it when the worker stops
        dismissProgress()
        isDownloading = false

        context.notify(
            Notifications.ID_DOWNLOAD_CHAPTER_PAUSED,
            Notifications.CHANNEL_DOWNLOADER_PROGRESS,
        ) {
            setContentTitle(context.stringResource(MR.strings.chapter_paused))
            setContentText(context.stringResource(MR.strings.download_notifier_download_paused))
            setSmallIcon(MaterialSymbolsR.drawable.rounded_filled_pause)
            setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
            setOnlyAlertOnce(true)
            // Open download manager when clicked
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
            // Resume action
            addAction(
                MaterialSymbolsR.drawable.rounded_filled_play_arrow,
                context.stringResource(MR.strings.action_resume),
                NotificationReceiver.resumeDownloadsPendingBroadcast(context),
            )
            // Clear action
            addAction(
                MaterialSymbolsR.drawable.rounded_close,
                context.stringResource(MR.strings.action_cancel_all),
                NotificationReceiver.clearDownloadsPendingBroadcast(context),
            )
        }
    }

    /**
     * Resets the state once downloads are completed.
     */
    @Synchronized
    fun onComplete() {
        dismissProgress()
        isDownloading = false
    }

    /**
     * Called when the downloader receives a warning.
     *
     * @param reason the text to show.
     * @param timeout duration after which to automatically dismiss the notification.
     * @param mangaId the id of the entry being warned about
     * Only works on Android 8+.
     */
    fun onWarning(reason: String, timeout: Long? = null, contentIntent: PendingIntent? = null, mangaId: Long? = null) {
        // Temporary workaround: suppress the raw NPE from a null javaClass dereference
        val isNullClassWarning =
            reason.contains("NullPointerException") ||
                (reason.contains("getClass()") && reason.contains("null object reference"))

        if (isNullClassWarning) {
            return
        }

        context.notify(
            Notifications.ID_DOWNLOAD_CHAPTER_ERROR,
            Notifications.CHANNEL_DOWNLOADER_ERROR,
        ) {
            setContentTitle(context.stringResource(MR.strings.download_notifier_downloader_title))
            setStyle(NotificationCompat.BigTextStyle().bigText(reason))
            setSmallIcon(MaterialSymbolsR.drawable.rounded_filled_warning)
            setAutoCancel(true)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
            if (mangaId != null) {
                addAction(
                    MaterialSymbolsR.drawable.rounded_book,
                    context.stringResource(MR.strings.action_show_manga),
                    NotificationReceiver.openEntryPendingActivity(context, mangaId),
                )
            }
            timeout?.let { setTimeoutAfter(it) }
            contentIntent?.let { setContentIntent(it) }
        }

        // Reset download information
        isDownloading = false
    }

    /**
     * Called when the downloader receives an error. It's shown as a separate notification to avoid
     * being overwritten.
     *
     * @param error string containing error information.
     * @param chapter string containing chapter title.
     * @param mangaId the id of the entry that the error occurred on
     */
    fun onError(error: String? = null, chapter: String? = null, mangaTitle: String? = null, mangaId: Long? = null) {
        // Temporary workaround: suppress the raw NPE from a null javaClass dereference
        val isNullClassError =
            error?.contains("NullPointerException") == true ||
                (error?.contains("getClass()") == true && error.contains("null object reference"))

        if (isNullClassError) {
            return
        }

        // Create notification
        context.notify(
            Notifications.ID_DOWNLOAD_CHAPTER_ERROR,
            Notifications.CHANNEL_DOWNLOADER_ERROR,
        ) {
            setContentTitle(
                mangaTitle?.plus(": $chapter") ?: context.stringResource(MR.strings.download_notifier_downloader_title),
            )
            setContentText(error ?: context.stringResource(MR.strings.download_notifier_unknown_error))
            setSmallIcon(MaterialSymbolsR.drawable.rounded_filled_warning)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
            if (mangaId != null) {
                addAction(
                    MaterialSymbolsR.drawable.rounded_book,
                    context.stringResource(MR.strings.action_show_manga),
                    NotificationReceiver.openEntryPendingActivity(context, mangaId),
                )
            }
        }

        // Reset download information
        isDownloading = false
    }
}

private const val PROGRESS_NOTIFICATION_INTERVAL_MS = 500L
