package eu.kanade.presentation.history.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import eu.kanade.presentation.theme.TachiyomiPreviewTheme
import tachiyomi.domain.history.model.HistoryDeletionRange
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.components.LabeledCheckbox
import tachiyomi.presentation.core.components.material.padding
import tachiyomi.presentation.core.i18n.stringResource

@Composable
fun HistoryDeleteDialog(
    onDismissRequest: () -> Unit,
    onDelete: (Boolean) -> Unit,
) {
    var removeEverything by remember { mutableStateOf(false) }

    AlertDialog(
        title = {
            Text(text = stringResource(MR.strings.action_remove))
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.padding.small),
            ) {
                Text(text = stringResource(MR.strings.dialog_with_checkbox_remove_description))

                LabeledCheckbox(
                    label = stringResource(MR.strings.dialog_with_checkbox_reset),
                    checked = removeEverything,
                    onCheckedChange = { removeEverything = it },
                )
            }
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = {
                onDelete(removeEverything)
                onDismissRequest()
            }) {
                Text(text = stringResource(MR.strings.action_remove))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(MR.strings.action_cancel))
            }
        },
    )
}

@Composable
fun HistoryDeleteAllDialog(
    onDismissRequest: () -> Unit,
    onDelete: (HistoryDeletionRange) -> Unit,
) {
    var selectedRange by remember { mutableStateOf(HistoryDeletionRange.LAST_HOUR) }
    val ranges = listOf(
        HistoryDeletionRange.LAST_HOUR to MR.strings.history_delete_last_hour,
        HistoryDeletionRange.TODAY_AND_YESTERDAY to MR.strings.history_delete_today_and_yesterday,
        HistoryDeletionRange.EVERYTHING to MR.strings.history_delete_everything,
    )

    AlertDialog(
        title = {
            Text(text = stringResource(MR.strings.pref_clear_history))
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.padding.small)) {
                Text(text = stringResource(MR.strings.history_delete_range_description))
                ranges.forEach { (range, label) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedRange = range },
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            selected = selectedRange == range,
                            onClick = { selectedRange = range },
                        )
                        Text(text = stringResource(label))
                    }
                }
            }
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = {
                onDelete(selectedRange)
                onDismissRequest()
            }) {
                Text(text = stringResource(MR.strings.action_remove))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(MR.strings.action_cancel))
            }
        },
    )
}

@PreviewLightDark
@Composable
private fun HistoryDeleteDialogPreview() {
    TachiyomiPreviewTheme {
        HistoryDeleteDialog(
            onDismissRequest = {},
            onDelete = {},
        )
    }
}
