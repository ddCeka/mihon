package tachiyomi.domain.track.local.interactor

import tachiyomi.domain.track.local.model.LocalReadingStatus
import tachiyomi.domain.track.local.repository.LocalTrackRepository

class SetLocalReadingStatus(
    private val repository: LocalTrackRepository,
) {

    /**
     * Sets the local reading [status] for the given manga. [LocalReadingStatus.READING] is the
     * implicit default and is therefore stored by removing any explicit row instead of persisting it.
     */
    suspend fun await(mangaId: Long, status: LocalReadingStatus) {
        if (status == LocalReadingStatus.READING) {
            repository.delete(mangaId)
        } else {
            repository.set(mangaId, status)
        }
    }
}
