package eu.kanade.presentation.more.stats.data

import tachiyomi.domain.track.local.model.LocalReadingStatus

sealed interface StatsData {

    data class Overview(
        val libraryMangaCount: Int,
        val completedMangaCount: Int,
        val totalReadDuration: Long,
    ) : StatsData

    data class Titles(
        val globalUpdateItemCount: Int,
        val startedMangaCount: Int,
        val localMangaCount: Int,
    ) : StatsData

    data class Chapters(
        val totalChapterCount: Int,
        val readChapterCount: Int,
        val downloadCount: Int,
    ) : StatsData

    data class TrackedTitle(
        val mangaId: Long,
        val title: String,
        val status: LocalReadingStatus,
    ) : StatsData
}
