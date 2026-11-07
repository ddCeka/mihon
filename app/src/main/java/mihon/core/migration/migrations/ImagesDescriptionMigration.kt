package mihon.core.migration.migrations

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoSet
import dev.zacsweers.metro.Inject
import eu.kanade.domain.ui.UiPreferences
import mihon.core.migration.Migration
import mihon.core.migration.MigrationContext

@Inject
@ContributesIntoSet(AppScope::class)
class ImagesDescriptionMigration(
    private val uiPreferences: UiPreferences,
) : Migration {
    override val version: Float = 40f

    override suspend fun invoke(migrationContext: MigrationContext): Boolean {
        uiPreferences.imagesInDescription.delete()
        return true
    }
}
