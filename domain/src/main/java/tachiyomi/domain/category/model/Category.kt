package tachiyomi.domain.category.model

import java.io.Serializable

data class Category(
    val id: Long,
    val name: String,
    val order: Long,
    val flags: Long,
) : Serializable {

    val isSystemCategory: Boolean = id == UNCATEGORIZED_ID

    companion object {
        const val UNCATEGORIZED_ID = 0L

        /**
         * Virtual category id for the in-app tracker "Backlog" tab (Plan-to-read + On-hold entries).
         * Negative so it never collides with real, persisted category ids.
         */
        const val BACKLOG_ID = -100L
    }
}
