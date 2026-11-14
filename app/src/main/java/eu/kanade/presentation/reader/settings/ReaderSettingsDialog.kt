package eu.kanade.presentation.reader.settings

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.DialogWindowProvider
import dev.icerock.moko.resources.StringResource
import eu.kanade.presentation.components.TabbedDialog
import eu.kanade.presentation.components.TabbedDialogPaddings
import eu.kanade.tachiyomi.ui.reader.setting.ReaderSettingsViewModel
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.i18n.stringResource

private enum class ReaderSettingsTab(val titleRes: StringResource) {
    TEXT(MR.strings.reader_text_tab),
    READING_MODE(MR.strings.pref_category_reading_mode),
    GENERAL(MR.strings.pref_category_general),
    COLOR_FILTER(MR.strings.custom_filter),
}

@Composable
fun ReaderSettingsDialog(
    onDismissRequest: () -> Unit,
    onShowMenus: () -> Unit,
    onHideMenus: () -> Unit,
    viewModel: ReaderSettingsViewModel,
    isTextBook: Boolean,
) {
    val tabs = ReaderSettingsTab.entries.filter { it != ReaderSettingsTab.TEXT || isTextBook }
    val tabTitles = tabs.map { stringResource(it.titleRes) }
    val pagerState = rememberPagerState { tabs.size }

    BoxWithConstraints {
        TabbedDialog(
            modifier = Modifier.heightIn(max = maxHeight * 0.75f),
            onDismissRequest = {
                onDismissRequest()
                onShowMenus()
            },
            tabTitles = tabTitles,
            pagerState = pagerState,
        ) { page ->
            val window = (LocalView.current.parent as? DialogWindowProvider)?.window

            LaunchedEffect(pagerState.currentPage) {
                if (tabs[pagerState.currentPage] == ReaderSettingsTab.COLOR_FILTER) {
                    window?.setDimAmount(0f)
                    onHideMenus()
                } else {
                    window?.setDimAmount(0.5f)
                    onShowMenus()
                }
            }

            Column(
                modifier = Modifier
                    .padding(vertical = TabbedDialogPaddings.Vertical)
                    .verticalScroll(rememberScrollState()),
            ) {
                when (tabs[page]) {
                    ReaderSettingsTab.TEXT -> TextSettingsPage(viewModel)
                    ReaderSettingsTab.READING_MODE -> ReadingModePage(viewModel)
                    ReaderSettingsTab.GENERAL -> GeneralPage(viewModel)
                    ReaderSettingsTab.COLOR_FILTER -> ColorFilterPage(viewModel)
                }
            }
        }
    }
}
