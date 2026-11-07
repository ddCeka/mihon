package mihon.core.migration.migrations

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.Inject
import eu.kanade.domain.source.service.SourcePreferences
import mihon.core.migration.Migration
import mihon.core.migration.MigrationContext
import tachiyomi.domain.library.model.LibraryDisplayMode
import tachiyomi.domain.library.service.LibraryPreferences

@Inject
@ContributesIntoSet(AppScope::class)
class DisplayModeMigration(
    private val libraryPreferences: LibraryPreferences,
    private val sourcePreferences: SourcePreferences,
) : Migration {
    override val version: Float = 40f

    override suspend fun invoke(migrationContext: MigrationContext): Boolean {
        if (libraryPreferences.displayMode.get() == LibraryDisplayMode.CompactGrid) {
            libraryPreferences.displayMode.set(LibraryDisplayMode.ComfortableGrid)
        }
        if (sourcePreferences.sourceDisplayMode.get() == LibraryDisplayMode.CompactGrid) {
            sourcePreferences.sourceDisplayMode.set(LibraryDisplayMode.ComfortableGrid)
        }
        return true
    }
}
