package tachiyomi.domain.track.local.interactor

import kotlinx.coroutines.flow.Flow
import tachiyomi.domain.track.local.model.MangaLocalTrack
import tachiyomi.domain.track.local.repository.LocalTrackRepository

class GetLocalTracks(
    private val repository: LocalTrackRepository,
) {

    suspend fun await(): List<MangaLocalTrack> {
        return repository.getAll()
    }

    fun subscribe(): Flow<List<MangaLocalTrack>> {
        return repository.getAllAsFlow()
    }

    suspend fun await(mangaId: Long): MangaLocalTrack? {
        return repository.getByMangaId(mangaId)
    }
}
