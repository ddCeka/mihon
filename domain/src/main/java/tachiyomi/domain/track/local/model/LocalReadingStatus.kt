package tachiyomi.domain.track.local.model

/**
 * User-facing reading status for the in-app (local) tracker.
 *
 * [READING] is the implicit default for any library entry that has no explicit status stored, so it
 * is never persisted; only [COMPLETED], [PLAN_TO_READ] and [ON_HOLD] are written to the database.
 */
enum class LocalReadingStatus(val value: Long) {
    READING(1L),
    COMPLETED(2L),
    PLAN_TO_READ(3L),
    ON_HOLD(4L),
    ;

    companion object {
        fun fromValue(value: Long): LocalReadingStatus = entries.firstOrNull { it.value == value } ?: READING
    }
}
