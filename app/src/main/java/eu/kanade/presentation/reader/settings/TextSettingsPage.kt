package eu.kanade.presentation.reader.settings

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import eu.kanade.tachiyomi.ui.reader.setting.ReaderPreferences
import eu.kanade.tachiyomi.ui.reader.setting.ReaderSettingsViewModel
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.components.CheckboxItem
import tachiyomi.presentation.core.components.SettingsChipRow
import tachiyomi.presentation.core.components.SliderItem
import tachiyomi.presentation.core.i18n.stringResource
import tachiyomi.presentation.core.util.collectAsState
import java.text.NumberFormat

@Composable
internal fun ColumnScope.TextSettingsPage(viewModel: ReaderSettingsViewModel) {
    val preferences = viewModel.preferences
    val numberFormat = remember { NumberFormat.getPercentInstance() }

    val fontSize by preferences.textFontSize.collectAsState()
    SliderItem(
        value = fontSize,
        valueRange = 12..32,
        label = stringResource(MR.strings.reader_text_font_size),
        onChange = { preferences.textFontSize.set(it) },
    )

    val lineSpacing by preferences.textLineSpacing.collectAsState()
    SliderItem(
        value = lineSpacing,
        valueRange = 120..200,
        steps = 7,
        label = stringResource(MR.strings.reader_text_line_spacing),
        valueString = numberFormat.format(lineSpacing / 100f),
        onChange = { preferences.textLineSpacing.set(it) },
    )

    val sideMargin by preferences.textSideMargin.collectAsState()
    SliderItem(
        value = sideMargin,
        valueRange = 0..48,
        steps = 11,
        label = stringResource(MR.strings.reader_text_side_margin),
        onChange = { preferences.textSideMargin.set(it) },
    )

    val font by preferences.textFont.collectAsState()
    SettingsChipRow(MR.strings.reader_text_font) {
        ReaderPreferences.TextFont.entries.map {
            FilterChip(
                selected = it == font,
                onClick = { preferences.textFont.set(it) },
                label = { Text(stringResource(it.titleRes)) },
            )
        }
    }

    CheckboxItem(
        label = stringResource(MR.strings.reader_text_justify),
        pref = preferences.textJustify,
    )
}
