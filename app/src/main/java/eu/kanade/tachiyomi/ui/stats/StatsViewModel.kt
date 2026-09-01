package eu.kanade.tachiyomi.ui.stats

import androidx.compose.ui.util.fastDistinctBy
import androidx.lifecycle.viewModelScope
import eu.kanade.presentation.more.stats.StatsScreenState
import eu.kanade.presentation.more.stats.data.StatsData
import eu.kanade.tachiyomi.data.download.DownloadManager
import eu.kanade.tachiyomi.source.model.SManga
import kotlinx.coroutines.flow.update
import mihon.core.viewmodel.StateViewModel
import tachiyomi.core.common.util.lang.launchIO
import tachiyomi.domain.history.interactor.GetTotalReadDuration
import tachiyomi.domain.library.model.LibraryManga
import tachiyomi.domain.library.service.LibraryPreferences
import tachiyomi.domain.manga.interactor.GetLibraryManga
import tachiyomi.domain.track.local.interactor.GetLocalTracks
import tachiyomi.domain.track.local.model.LocalReadingStatus
import tachiyomi.source.local.isLocal
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

class StatsViewModel(
    private val downloadManager: DownloadManager = Injekt.get(),
    private val getLibraryManga: GetLibraryManga = Injekt.get(),
    private val getTotalReadDuration: GetTotalReadDuration = Injekt.get(),
    private val getLocalTracks: GetLocalTracks = Injekt.get(),
    private val preferences: LibraryPreferences = Injekt.get(),
) : StateViewModel<StatsScreenState>(StatsScreenState.Loading) {

    init {
        viewModelScope.launchIO {
            val libraryManga = getLibraryManga.await()

            val distinctLibraryManga = libraryManga.fastDistinctBy { it.id }

            val overviewStatData = StatsData.Overview(
                libraryMangaCount = distinctLibraryManga.size,
                completedMangaCount = distinctLibraryManga.count {
                    it.manga.status.toInt() == SManga.COMPLETED && it.unreadCount == 0L
                },
                totalReadDuration = getTotalReadDuration.await(),
            )

            val titlesStatData = StatsData.Titles(
                globalUpdateItemCount = getGlobalUpdateItemCount(libraryManga),
                startedMangaCount = distinctLibraryManga.count { it.hasStarted },
                localMangaCount = distinctLibraryManga.count { it.manga.isLocal() },
            )

            val chaptersStatData = StatsData.Chapters(
                totalChapterCount = distinctLibraryManga.sumOf { it.totalChapters }.toInt(),
                readChapterCount = distinctLibraryManga.sumOf { it.readCount }.toInt(),
                downloadCount = downloadManager.getDownloadCount(),
            )

            val trackedTitles = getTrackedTitles(distinctLibraryManga)

            mutableState.update {
                StatsScreenState.Success(
                    overview = overviewStatData,
                    titles = titlesStatData,
                    chapters = chaptersStatData,
                    tracked = trackedTitles,
                )
            }
        }
    }

    private fun getGlobalUpdateItemCount(libraryManga: List<LibraryManga>): Int {
        val includedCategories = preferences.updateCategories.get().map { it.toLong() }
        val excludedCategories = preferences.updateCategoriesExclude.get().map { it.toLong() }

        // Every favorited manga in the selected category scope is updated, so the count is simply
        // the in-scope size (heuristic per-manga skips were removed for update reliability).
        return libraryManga.count {
            val included = includedCategories.isEmpty() || it.categories.intersect(includedCategories).isNotEmpty()
            val excluded = it.categories.intersect(excludedCategories).isNotEmpty()
            included && !excluded
        }
    }

    /**
     * Builds the in-app tracker list. Every library entry has an effective status: its explicitly
     * stored [LocalReadingStatus], or [LocalReadingStatus.READING] when none is stored.
     */
    private suspend fun getTrackedTitles(libraryManga: List<LibraryManga>): List<StatsData.TrackedTitle> {
        val statusByMangaId = getLocalTracks.await().associate { it.mangaId to it.status }
        return libraryManga
            .map { libraryManga ->
                StatsData.TrackedTitle(
                    mangaId = libraryManga.id,
                    title = libraryManga.manga.title,
                    status = statusByMangaId[libraryManga.id] ?: LocalReadingStatus.READING,
                )
            }
            .sortedBy { it.title.lowercase() }
    }
}
