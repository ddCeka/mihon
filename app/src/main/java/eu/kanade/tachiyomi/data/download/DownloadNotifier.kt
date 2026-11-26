package eu.kanade.tachiyomi.data.download

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
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
import mihon.icons.materialsymbols.R as MaterialSymbolsR

/**
 * DownloadNotifier is used to show notifications when downloading one or multiple chapters.
 *
 * @param context context of application
 */
@Inject
@SingleIn(AppScope::class)
class DownloadNotifier(
    private val context: Context,
    private val preferences: SecurityPreferences,
) {

    private val activeDownloads = LinkedHashMap<Long, Download>()
    private val lastProgressNotificationTimes = mutableMapOf<Long, Long>()
    private val notificationLargeIcon by lazy {
        BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher)
    }

    /**
     * Status of download. Used for correct notification icon.
     */
    private var isDownloading = false

    @Synchronized
    fun setActiveDownloads(downloads: List<Download>) {
        val next = downloads.associateBy { it.chapter.id }

        (activeDownloads.keys - next.keys).forEach { chapterId ->
            context.cancelNotification(childNotificationId(chapterId))
            lastProgressNotificationTimes.remove(chapterId)
            activeDownloads.remove(chapterId)
        }

        next.forEach { (chapterId, download) ->
            val existing = activeDownloads[chapterId]
            // Avoid overwriting newer progress if a progress tick arrived first
            if (existing == null || download.downloadedImages >= existing.downloadedImages) {
                activeDownloads[chapterId] = download
            }
        }

        val active = activeDownloads.values.toList()
        if (active.isEmpty()) {
            dismissChildNotifications()
            return
        }

        val now = SystemClock.elapsedRealtime()
        if (active.size == 1) {
            // Avoid group summary + single child duplication
            dismissChildNotifications()
            val single = active.first()
            lastProgressNotificationTimes[single.chapter.id] = now
            context.notify(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS, buildSingleNotification(single))
        } else {
            context.notify(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS, buildSummaryNotification(active))
            active.forEach { download ->
                lastProgressNotificationTimes[download.chapter.id] = now
                renderChildNotification(download)
            }
        }
    }

    @Synchronized
    fun createForegroundNotification(): Notification {
        val active = activeDownloads.values.toList()
        return if (active.size == 1) {
            buildSingleNotification(active.first())
        } else {
            buildSummaryNotification(active)
        }
    }

    private fun baseProgressBuilder(): NotificationCompat.Builder {
        return context.notificationBuilder(Notifications.CHANNEL_DOWNLOADER_PROGRESS) {
            setSmallIcon(android.R.drawable.stat_sys_download)
            setLargeIcon(notificationLargeIcon)
            setOnlyAlertOnce(true)
            setOngoing(true)
            setAutoCancel(false)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
        }
    }

    private fun markDownloading() {
        if (!isDownloading) {
            context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
            isDownloading = true
        }
    }

    private fun buildSingleNotification(download: Download): Notification {
        markDownloading()
        val totalPages = download.pages?.size ?: 0
        val progress = download.downloadedImages.coerceAtMost(totalPages)

        return baseProgressBuilder().apply {
            setContentTitle(getDownloadTitle(download))
            setContentText(
                context.stringResource(
                    MR.strings.chapter_downloading_progress,
                    progress,
                    totalPages.coerceAtLeast(1),
                ),
            )
            setProgress(totalPages.coerceAtLeast(1), progress, false)
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
        }.build()
    }

    private fun buildSummaryNotification(downloads: List<Download>): Notification {
        if (downloads.isNotEmpty()) markDownloading()

        return baseProgressBuilder().apply {
            // Re-apply group flags on every build so DownloadWorker's foreground service cannot strip them
            setGroup(Notifications.GROUP_DOWNLOADER_PROGRESS)
            setGroupSummary(true)
            setContentTitle(context.stringResource(MR.strings.download_notifier_downloader_title))
            if (downloads.isNotEmpty()) {
                setContentText("Downloading ${downloads.size} chapters")
            }
            addAction(
                MaterialSymbolsR.drawable.rounded_filled_pause,
                context.stringResource(MR.strings.action_pause),
                NotificationReceiver.pauseDownloadsPendingBroadcast(context),
            )
        }.build()
    }

    private fun renderChildNotification(download: Download) {
        val totalPages = download.pages?.size ?: 0
        val progress = download.downloadedImages.coerceAtMost(totalPages)

        val notification = baseProgressBuilder().apply {
            setGroup(Notifications.GROUP_DOWNLOADER_PROGRESS)
            setGroupSummary(false)
            setContentTitle(getDownloadTitle(download))
            setContentText(
                context.stringResource(
                    MR.strings.chapter_downloading_progress,
                    progress,
                    totalPages.coerceAtLeast(1),
                ),
            )
            setProgress(totalPages.coerceAtLeast(1), progress, false)
        }.build()

        context.notify(childNotificationId(download.chapter.id), notification)
    }

    private fun getDownloadTitle(download: Download): String {
        return when {
            preferences.hideNotificationContent.get() -> {
                context.stringResource(MR.strings.download_notifier_downloader_title)
            }
            download.manga.title.isNotBlank() -> {
                "${download.manga.title.chop(18)} - ${download.chapter.name.chop(18)}"
            }
            else -> {
                download.chapter.name.chop(30)
            }
        }
    }

    private fun childNotificationId(chapterId: Long): Int {
        return Notifications.CHILD_PROGRESS_NOTIFICATION_OFFSET + (chapterId.hashCode() and Int.MAX_VALUE) % 100_000
    }

    private fun dismissChildNotifications() {
        activeDownloads.keys.forEach { chapterId ->
            context.cancelNotification(childNotificationId(chapterId))
        }
    }

    /**
     * Dismiss the downloader's notification. Downloader error notifications use a different id, so
     * those can only be dismissed by the user.
     */
    @Synchronized
    fun dismissProgress() {
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS)
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
        dismissChildNotifications()
        lastProgressNotificationTimes.clear()
        activeDownloads.clear()
        isDownloading = false
    }

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
        if (!activeDownloads.containsKey(download.chapter.id)) return
        activeDownloads[download.chapter.id] = download

        val now = SystemClock.elapsedRealtime()
        val totalPages = download.pages?.size ?: 0
        val isComplete = totalPages > 0 && download.downloadedImages >= totalPages
        val lastTime = lastProgressNotificationTimes[download.chapter.id] ?: 0L

        if (!isComplete && now - lastTime < PROGRESS_NOTIFICATION_INTERVAL_MS) return
        lastProgressNotificationTimes[download.chapter.id] = now

        if (activeDownloads.size == 1) {
            context.notify(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS, buildSingleNotification(download))
        } else {
            renderChildNotification(download)
        }
    }

    /**
     * Show notification when download is paused.
     */
    fun onPaused() {
        // The progress id belongs to the download worker's foreground service, which takes the
        // notification with it when the worker stops
        dismissProgress()

        context.notify(
            Notifications.ID_DOWNLOAD_CHAPTER_PAUSED,
            Notifications.CHANNEL_DOWNLOADER_PROGRESS,
        ) {
            setContentTitle(context.stringResource(MR.strings.chapter_paused))
            setContentText(context.stringResource(MR.strings.download_notifier_download_paused))
            setSmallIcon(MaterialSymbolsR.drawable.rounded_filled_pause)
            setLargeIcon(notificationLargeIcon)
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
