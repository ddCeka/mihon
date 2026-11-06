package eu.kanade.presentation.more.settings.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.navigation3.runtime.NavKey
import dev.icerock.moko.resources.StringResource
import eu.kanade.presentation.more.settings.Preference
import eu.kanade.presentation.more.settings.PreferenceScaffold
import mihon.core.navigation.LocalBackButtonVisibility
import mihon.core.navigation.LocalNavigator

/**
 * Identifies a preference by its position in the settings structure, not by its localized title.
 */
data class PreferenceHighlightTarget(
    val preferenceIndex: Int,
    val childIndex: Int? = null,
    val isGroupHeader: Boolean = false,
)

interface SearchableSettings : NavKey {

    @Composable
    @ReadOnlyComposable
    fun getTitleRes(): StringResource

    @Composable
    fun getPreferences(): List<Preference>

    @Composable
    fun RowScope.AppBarAction() {
    }

    @Composable
    fun Content() {
        val navigator = LocalNavigator.current
        val backVisibility = LocalBackButtonVisibility.current

        PreferenceScaffold(
            titleRes = getTitleRes(),
            onBackPressed = {
                navigator.pop()
                Unit
            }.takeIf { backVisibility },
            actions = { AppBarAction() },
            itemsProvider = { getPreferences() },
        )
    }

    companion object {
        // HACK: for the background blipping thingy.
        // The title of the target PreferenceItem
        // Set before showing the destination screen and reset after
        // See BasePreferenceWidget.highlightBackground
        var highlightKey: String? = null

        // Search uses a structural target so duplicate localized titles remain unambiguous.
        var highlightTarget: PreferenceHighlightTarget? = null
    }
}
