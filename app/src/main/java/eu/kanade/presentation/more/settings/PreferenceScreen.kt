package eu.kanade.presentation.more.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import eu.kanade.presentation.more.settings.screen.PreferenceHighlightTarget
import eu.kanade.presentation.more.settings.screen.SearchableSettings
import eu.kanade.presentation.more.settings.widget.PreferenceGroupHeader
import kotlinx.coroutines.delay
import tachiyomi.presentation.core.components.ScrollbarLazyColumn
import kotlin.time.Duration.Companion.seconds

/**
 * Preference Screen composable which contains a list of [Preference] items
 * @param items [Preference] items which should be displayed on the preference screen. An item can be a single [PreferenceItem] or a group ([Preference.PreferenceGroup])
 * @param modifier [Modifier] to be applied to the preferenceScreen layout
 */
@Composable
fun PreferenceScreen(
    items: List<Preference>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val state = rememberLazyListState()
    val highlightTarget = SearchableSettings.highlightTarget
    // Keep the title-based path for onboarding. Structural search targets take priority.
    val highlightKey = if (highlightTarget == null) SearchableSettings.highlightKey else null
    if (highlightTarget != null || highlightKey != null) {
        LaunchedEffect(highlightTarget, highlightKey) {
            val i = if (highlightTarget != null) {
                items.findHighlightedIndex(highlightTarget)
            } else {
                items.findHighlightedIndex(highlightKey!!)
            }
            if (i >= 0) {
                delay(0.5.seconds)
                state.animateScrollToItem(i)
            }
            SearchableSettings.highlightKey = null
            SearchableSettings.highlightTarget = null
        }
    }

    ScrollbarLazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
    ) {
        items.fastForEachIndexed { i, preference ->
            when (preference) {
                // Create Preference Group
                is Preference.PreferenceGroup -> {
                    if (!preference.visible) return@fastForEachIndexed

                    item {
                        Column {
                            PreferenceGroupHeader(
                                title = preference.title,
                                highlighted = if (highlightTarget != null) {
                                    highlightTarget.isGroupHeader &&
                                        highlightTarget.preferenceIndex == i
                                } else {
                                    preference.title == highlightKey
                                },
                            )
                        }
                    }
                    itemsIndexed(preference.preferenceItems) { childIndex, item ->
                        PreferenceItem(
                            item = item,
                            highlightKey = highlightKey,
                            highlighted = highlightTarget?.let {
                                !it.isGroupHeader &&
                                    it.preferenceIndex == i &&
                                    it.childIndex == childIndex
                            } == true,
                        )
                    }
                    item {
                        if (i < items.lastIndex) {
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }

                // Create Preference Item
                is Preference.PreferenceItem<*, *> -> item {
                    PreferenceItem(
                        item = preference,
                        highlightKey = highlightKey,
                        highlighted = highlightTarget?.let {
                            !it.isGroupHeader &&
                                it.preferenceIndex == i &&
                                it.childIndex == null
                        } == true,
                    )
                }
            }
        }
    }
}

private fun List<Preference>.findHighlightedIndex(target: PreferenceHighlightTarget): Int {
    var lazyIndex = 0

    forEachIndexed { preferenceIndex, preference ->
        when (preference) {
            is Preference.PreferenceGroup -> {
                if (!preference.visible) return@forEachIndexed

                if (target.preferenceIndex == preferenceIndex && target.isGroupHeader) {
                    return lazyIndex
                }
                lazyIndex++ // Group header

                preference.preferenceItems.forEachIndexed { childIndex, _ ->
                    if (
                        target.preferenceIndex == preferenceIndex &&
                        !target.isGroupHeader &&
                        target.childIndex == childIndex
                    ) {
                        return lazyIndex
                    }
                    lazyIndex++
                }

                if (preferenceIndex < lastIndex) lazyIndex++ // Spacer
            }
            is Preference.PreferenceItem<*, *> -> {
                if (
                    target.preferenceIndex == preferenceIndex &&
                    !target.isGroupHeader &&
                    target.childIndex == null
                ) {
                    return lazyIndex
                }
                lazyIndex++
            }
        }
    }

    return -1
}

private fun List<Preference>.findHighlightedIndex(highlightKey: String): Int {
    return flatMap { preference ->
        when (preference) {
            is Preference.PreferenceGroup -> {
                if (!preference.visible) {
                    emptyList()
                } else {
                    buildList<String?> {
                        add(preference.title) // Header
                        addAll(preference.preferenceItems.map { it.title })
                        add(null) // Spacer
                    }
                }
            }
            is Preference.PreferenceItem<*, *> -> listOf(preference.title)
        }
    }.indexOfFirst { it == highlightKey }
}
