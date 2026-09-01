package tachiyomi.domain.track.local.model

data class MangaLocalTrack(
    val mangaId: Long,
    val status: LocalReadingStatus,
)
