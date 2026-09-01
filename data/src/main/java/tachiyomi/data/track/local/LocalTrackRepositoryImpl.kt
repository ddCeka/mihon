package tachiyomi.data.track.local

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
import kotlinx.coroutines.flow.Flow
import tachiyomi.data.Database
import tachiyomi.data.subscribeToList
import tachiyomi.domain.track.local.model.LocalReadingStatus
import tachiyomi.domain.track.local.model.MangaLocalTrack
import tachiyomi.domain.track.local.repository.LocalTrackRepository

class LocalTrackRepositoryImpl(
    private val database: Database,
) : LocalTrackRepository {

    override suspend fun getAll(): List<MangaLocalTrack> {
        return database.manga_local_trackQueries
            .getAll(::mapLocalTrack)
            .awaitAsList()
    }

    override fun getAllAsFlow(): Flow<List<MangaLocalTrack>> {
        return database.manga_local_trackQueries
            .getAll(::mapLocalTrack)
            .subscribeToList()
    }

    override suspend fun getByMangaId(mangaId: Long): MangaLocalTrack? {
        return database.manga_local_trackQueries
            .getByMangaId(mangaId, ::mapLocalTrack)
            .awaitAsOneOrNull()
    }

    override suspend fun set(mangaId: Long, status: LocalReadingStatus) {
        database.manga_local_trackQueries.upsert(
            mangaId = mangaId,
            status = status.value,
            lastModified = System.currentTimeMillis(),
        )
    }

    override suspend fun delete(mangaId: Long) {
        database.manga_local_trackQueries.deleteByMangaId(mangaId)
    }

    private fun mapLocalTrack(mangaId: Long, status: Long): MangaLocalTrack = MangaLocalTrack(
        mangaId = mangaId,
        status = LocalReadingStatus.fromValue(status),
    )
}
