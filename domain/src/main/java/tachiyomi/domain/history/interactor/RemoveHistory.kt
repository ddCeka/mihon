package tachiyomi.domain.history.interactor

import dev.zacsweers.metro.Inject
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
import tachiyomi.domain.history.model.HistoryDeletionRange
import tachiyomi.domain.history.model.HistoryWithRelations
import tachiyomi.domain.history.repository.HistoryRepository
import kotlin.time.Clock
import kotlin.time.Duration.Companion.hours

@Inject
class RemoveHistory(
    private val repository: HistoryRepository,
) {

    suspend fun awaitAll(): Boolean {
        return repository.deleteAllHistory()
    }

    suspend fun await(range: HistoryDeletionRange): Boolean {
        if (range == HistoryDeletionRange.EVERYTHING) {
            return repository.deleteAllHistory()
        }

        val now = Clock.System.now()
        val timeZone = TimeZone.currentSystemDefault()
        val startInclusive = when (range) {
            HistoryDeletionRange.LAST_HOUR -> now - 1.hours
            HistoryDeletionRange.TODAY_AND_YESTERDAY -> {
                val today = now.toLocalDateTime(timeZone).date
                today.minus(DatePeriod(days = 1)).atStartOfDayIn(timeZone)
            }
            HistoryDeletionRange.EVERYTHING -> error("Handled above")
        }

        return repository.deleteHistoryInRange(startInclusive, now)
    }

    suspend fun await(history: HistoryWithRelations) {
        repository.resetHistory(history.id)
    }

    suspend fun await(mangaId: Long) {
        repository.resetHistoryByMangaId(mangaId)
    }
}
