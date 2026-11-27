package eu.kanade.presentation.reader

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import eu.kanade.tachiyomi.ui.reader.model.ReaderChapter
import mihon.icons.materialsymbols.MaterialSymbols
import mihon.icons.materialsymbols.rounded.Close
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.i18n.stringResource
import kotlin.math.abs
import kotlin.math.floor

@Composable
fun ReaderChapterSearchDialog(
    chapters: List<ReaderChapter>,
    currentChapterId: Long?,
    onDismissRequest: () -> Unit,
    onSelectChapter: (ReaderChapter) -> Unit,
) {
    var query by rememberSaveable { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val listState = rememberLazyListState()

    val filteredChapters = remember(chapters, query) {
        val trimmed = query.trim()
        if (trimmed.isEmpty()) {
            chapters
        } else {
            val targetNumber = trimmed.toDoubleOrNull()
            val isExactMatch = '.' in trimmed
            chapters.filter { readerChapter ->
                val chapter = readerChapter.chapter
                if (targetNumber != null && chapter.isRecognizedNumber) {
                    val num = chapter.chapterNumber
                    if (isExactMatch) {
                        abs(num - targetNumber) < 0.0001
                    } else {
                        floor(num) == targetNumber
                    }
                } else {
                    chapter.name.contains(trimmed, ignoreCase = true)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        val currentIndex = chapters.indexOfFirst { it.chapter.id == currentChapterId }
        if (currentIndex >= 0) {
            listState.scrollToItem(currentIndex)
        }
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = stringResource(MR.strings.action_search)) },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    placeholder = { Text(text = stringResource(MR.strings.show_chapter_number)) },
                    singleLine = true,
                    trailingIcon = if (query.isNotEmpty()) {
                        {
                            IconButton(onClick = { query = "" }) {
                                Icon(
                                    imageVector = MaterialSymbols.Rounded.Close,
                                    contentDescription = null,
                                )
                            }
                        }
                    } else {
                        null
                    },
                )
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 320.dp)
                        .padding(top = 8.dp),
                ) {
                    items(
                        items = filteredChapters,
                        key = { it.chapter.id },
                    ) { readerChapter ->
                        val isCurrent = readerChapter.chapter.id == currentChapterId
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSelectChapter(readerChapter)
                                    onDismissRequest()
                                }
                                .padding(vertical = 12.dp, horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = readerChapter.chapter.name,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                color = if (isCurrent) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurface
                                },
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(MR.strings.action_cancel))
            }
        },
    )
}
