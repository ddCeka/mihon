package tachiyomi.domain.track.local.repository

import kotlinx.coroutines.flow.Flow
import tachiyomi.domain.track.local.model.LocalReadingStatus
import tachiyomi.domain.track.local.model.MangaLocalTrack

interface LocalTrackRepository {

    suspend fun getAll(): List<MangaLocalTrack>

    fun getAllAsFlow(): Flow<List<MangaLocalTrack>>

    suspend fun getByMangaId(mangaId: Long): MangaLocalTrack?

    suspend fun set(mangaId: Long, status: LocalReadingStatus)

    suspend fun delete(mangaId: Long)
}
