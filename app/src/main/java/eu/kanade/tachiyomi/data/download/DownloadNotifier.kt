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

    private val progressNotificationBuilder by lazy {
        context.notificationBuilder(Notifications.CHANNEL_DOWNLOADER_PROGRESS) {
            setLargeIcon(notificationLargeIcon)
            setAutoCancel(false)
            setOnlyAlertOnce(true)
        }
    }

    /**
     * State for grouped progress notifications:
     * - one notification for ongoing download batch (or single chapter when count == 1)
     * - one child notification per active chapter when count > 1
     */
    private val childNotificationIds = mutableMapOf<Long, Int>()
    private val activeDownloads = LinkedHashMap<Long, Download>()

    private val lastProgressNotificationTimes = mutableMapOf<Long, Long>()
    private val notificationLargeIcon by lazy {
        BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher)
    }

    /**
     * Status of download. Used for correct notification icon and state transitions.
     */
    private var isDownloading = false

    /**
     * Tracks whether the builder is currently configured as a group summary (2+ chapters).
     */
    private var isGroupedMode = false

    /**
     * Updates the current set of active downloads and reconciles the notification tree.
     */
    @Synchronized
    fun setActiveDownloads(downloads: List<Download>) {
        val next = downloads.associateBy { it.chapter.id }
        val previous = activeDownloads.toMap()

        // Remove stale notifications
        (previous.keys - next.keys).forEach { chapterId ->
            childNotificationIds.remove(chapterId)?.let { childId ->
                context.cancelNotification(childId)
            }
            lastProgressNotificationTimes.remove(chapterId)
            activeDownloads.remove(chapterId)
        }

        // Update existing and add new
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

        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_COMPLETE)

        val now = SystemClock.elapsedRealtime()
        if (active.size == 1) {
            // Single active download: avoid group summary + 1 child duplication
            dismissChildNotifications()
            val single = active.first()
            lastProgressNotificationTimes[single.chapter.id] = now
            renderSingleNotification(single)
        } else {
            // Multiple active downloads: render group summary + per-chapter child notifications
            renderSummaryNotification(active)
            active.forEach { download ->
                lastProgressNotificationTimes[download.chapter.id] = now
                renderChildNotification(download)
            }
        }
    }

    private fun makeStableChildNotificationId(chapterId: Long): Int {
        return childNotificationIds.getOrPut(chapterId) {
            val base = chapterId.hashCode() and Int.MAX_VALUE
            val id = Notifications.CHILD_PROGRESS_NOTIFICATION_OFFSET + (base % 100000)
            if (id == Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS) id + 1 else id
        }
    }

    @Synchronized
    fun createForegroundNotification(): Notification {
        val active = activeDownloads.values.toList()
        return when {
            // Avoid mutating progressNotificationBuilder before activeDownloadsFlow emits
            active.isEmpty() -> context.notificationBuilder(Notifications.CHANNEL_DOWNLOADER_PROGRESS) {
                setSmallIcon(android.R.drawable.stat_sys_download)
                setLargeIcon(notificationLargeIcon)
                setContentTitle(context.stringResource(MR.strings.download_notifier_downloader_title))
                setOnlyAlertOnce(true)
                setOngoing(true)
                setAutoCancel(false)
                setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
            }.build()

            active.size == 1 -> buildSingleNotification(active.first())
            else -> buildSummaryNotification(active)
        }
    }

    private fun buildSingleNotification(download: Download): Notification {
        val totalPages = download.pages?.size ?: 0
        val progress = download.downloadedImages.coerceAtMost(totalPages)

        return with(progressNotificationBuilder) {
            if (!isDownloading || isGroupedMode) {
                context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
                isDownloading = true
                isGroupedMode = false
            }

            setSmallIcon(android.R.drawable.stat_sys_download)
            setLargeIcon(notificationLargeIcon)
            setGroup(null)
            setGroupSummary(false)
            setOnlyAlertOnce(true)
            setOngoing(true)
            setAutoCancel(false)
            setTimeoutAfter(0L)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))

            clearActions()
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

            setContentTitle(getDownloadTitle(download))
            setContentText(
                context.stringResource(
                    MR.strings.chapter_downloading_progress,
                    progress,
                    totalPages.coerceAtLeast(1),
                ),
            )
            setProgress(totalPages.coerceAtLeast(1), progress, false)
            build()
        }
    }

    private fun renderSingleNotification(download: Download) {
        context.notify(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS, buildSingleNotification(download))
    }

    private fun buildSummaryNotification(downloads: List<Download>): Notification {
        val count = downloads.size
        val title = context.stringResource(MR.strings.download_notifier_downloader_title)
        val text = when {
            count == 0 -> null
            count == 1 -> {
                context.stringResource(
                    MR.strings.chapter_downloading_progress,
                    downloads.first().downloadedImages,
                    downloads.first().pages?.size ?: 1,
                )
            }
            else -> "Downloading $count chapters"
        }

        return with(progressNotificationBuilder) {
            if ((!isDownloading || !isGroupedMode) && count > 0) {
                context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
                isDownloading = true
                isGroupedMode = true
            }

            // Re-apply group flags on every build so DownloadWorker's foreground service cannot strip them
            setSmallIcon(android.R.drawable.stat_sys_download)
            setLargeIcon(notificationLargeIcon)
            setGroup(Notifications.GROUP_DOWNLOADER_PROGRESS)
            setGroupSummary(true)
            setOnlyAlertOnce(true)
            setOngoing(true)
            setAutoCancel(false)
            setTimeoutAfter(0L)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
            setProgress(0, 0, false)

            clearActions()
            addAction(
                MaterialSymbolsR.drawable.rounded_filled_pause,
                context.stringResource(MR.strings.action_pause),
                NotificationReceiver.pauseDownloadsPendingBroadcast(context),
            )
            if (count == 1) {
                addAction(
                    MaterialSymbolsR.drawable.rounded_book,
                    context.stringResource(MR.strings.action_show_manga),
                    NotificationReceiver.openEntryPendingActivity(context, downloads.first().manga.id),
                )
            }

            setContentTitle(title)
            setContentText(text)
            build()
        }
    }

    private fun renderSummaryNotification(downloads: List<Download>) {
        if (downloads.isEmpty()) return
        context.notify(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS, buildSummaryNotification(downloads))
    }

    private fun renderChildNotification(download: Download) {
        val chapterId = download.chapter.id
        val childId = childNotificationIds.getOrPut(chapterId) {
            makeStableChildNotificationId(chapterId)
        }
        val totalPages = download.pages?.size ?: 0
        val progress = download.downloadedImages.coerceAtMost(totalPages)

        context.notify(
            childId,
            Notifications.CHANNEL_DOWNLOADER_PROGRESS,
        ) {
            setGroupSummary(false)
            setGroup(Notifications.GROUP_DOWNLOADER_PROGRESS)
            setSmallIcon(android.R.drawable.stat_sys_download)
            setLargeIcon(notificationLargeIcon)
            setAutoCancel(false)
            setOnlyAlertOnce(true)
            setOngoing(true)
            setContentTitle(getDownloadTitle(download))
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

    private fun dismissChildNotifications() {
        childNotificationIds.values.forEach { childId ->
            context.cancelNotification(childId)
        }
        childNotificationIds.clear()
    }

    /**
     * Dismiss the downloader's notification. Downloader error notifications use a different id, so
     * those can only be dismissed by the user.
     */
    @Synchronized
    fun dismissProgress() {
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PROGRESS)
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_PAUSED)
        context.cancelNotification(Notifications.ID_DOWNLOAD_CHAPTER_COMPLETE)
        dismissChildNotifications()
        lastProgressNotificationTimes.clear()
        activeDownloads.clear()
        isDownloading = false
        isGroupedMode = false
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
        // Ignore ticks for downloads that were canceled or not yet registered
        if (!activeDownloads.containsKey(download.chapter.id)) return
        activeDownloads[download.chapter.id] = download

        // Throttle per chapter ID, always letting the final completion tick through
        val now = SystemClock.elapsedRealtime()
        val totalPages = download.pages?.size ?: 0
        val isComplete = totalPages > 0 && download.downloadedImages >= totalPages
        val lastTime = lastProgressNotificationTimes[download.chapter.id] ?: 0L

        if (!isComplete && now - lastTime < PROGRESS_NOTIFICATION_INTERVAL_MS) return
        lastProgressNotificationTimes[download.chapter.id] = now

        val allActive = activeDownloads.values.toList()
        if (allActive.size == 1) {
            renderSingleNotification(download)
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
     * Resets the state once downloads are completed and shows a completion banner.
     */
    @Synchronized
    fun onComplete() {
        dismissProgress()

        // Post on a dedicated ID after DownloadWorker finishes so foreground service teardown does not cancel it
        context.notify(
            Notifications.ID_DOWNLOAD_CHAPTER_COMPLETE,
            Notifications.CHANNEL_DOWNLOADER_PROGRESS,
        ) {
            setGroup(null)
            setGroupSummary(false)
            setProgress(0, 0, false)
            clearActions()
            setContentTitle(context.stringResource(MR.strings.download_notifier_downloader_title))
            setContentText(context.stringResource(MR.strings.download_notifier_download_finished))
            setSmallIcon(android.R.drawable.stat_sys_download_done)
            setLargeIcon(notificationLargeIcon)
            setOngoing(false)
            setAutoCancel(true)
            setOnlyAlertOnce(true)
            setTimeoutAfter(3000L)
            setContentIntent(NotificationHandler.openDownloadManagerPendingActivity(context))
        }
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
        isGroupedMode = false
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
        isGroupedMode = false
    }
}

private const val PROGRESS_NOTIFICATION_INTERVAL_MS = 500L
