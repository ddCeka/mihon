package eu.kanade.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastMaxBy
import dev.icerock.moko.resources.StringResource
import eu.kanade.presentation.theme.TachiyomiPreviewTheme
import mihon.icons.materialsymbols.MaterialSymbols
import mihon.icons.materialsymbols.rounded.Close
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.i18n.stringResource

val DownloadedOnlyBannerBackgroundColor
    @Composable get() = MaterialTheme.colorScheme.tertiary
val IncognitoModeBannerBackgroundColor
    @Composable get() = MaterialTheme.colorScheme.primary
val IndexingBannerBackgroundColor
    @Composable get() = MaterialTheme.colorScheme.secondary

@Composable
fun WarningBanner(
    textRes: StringResource,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(textRes),
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.error)
            .padding(16.dp),
        color = MaterialTheme.colorScheme.onError,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun AppStateBanners(
    downloadedOnlyMode: Boolean,
    incognitoMode: Boolean,
    indexing: Boolean,
    onDownloadedOnlyClick: () -> Unit,
    onIncognitoModeClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val mainInsets = WindowInsets.statusBars
    val mainInsetsTop = mainInsets.getTop(density)
    SubcomposeLayout(modifier = modifier) { constraints ->
        val indexingPlaceable = subcompose(0) {
            AnimatedVisibility(
                visible = indexing,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                IndexingDownloadBanner(
                    modifier = Modifier.windowInsetsPadding(mainInsets),
                )
            }
        }.fastMap { it.measure(constraints) }
        val indexingHeight = indexingPlaceable.fastMaxBy { it.height }?.height ?: 0

        val downloadedOnlyPlaceable = subcompose(1) {
            AnimatedVisibility(
                visible = downloadedOnlyMode,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                val top = (mainInsetsTop - indexingHeight).coerceAtLeast(0)
                DownloadedOnlyModeBanner(
                    onClick = onDownloadedOnlyClick,
                    modifier = Modifier.windowInsetsPadding(WindowInsets(top = top)),
                )
            }
        }.fastMap { it.measure(constraints) }
        val downloadedOnlyHeight = downloadedOnlyPlaceable.fastMaxBy { it.height }?.height ?: 0

        val incognitoPlaceable = subcompose(2) {
            AnimatedVisibility(
                visible = incognitoMode,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                val top = (mainInsetsTop - indexingHeight - downloadedOnlyHeight).coerceAtLeast(0)
                IncognitoModeBanner(
                    onClick = onIncognitoModeClick,
                    modifier = Modifier.windowInsetsPadding(WindowInsets(top = top)),
                )
            }
        }.fastMap { it.measure(constraints) }
        val incognitoHeight = incognitoPlaceable.fastMaxBy { it.height }?.height ?: 0

        layout(constraints.maxWidth, indexingHeight + downloadedOnlyHeight + incognitoHeight) {
            indexingPlaceable.fastForEach {
                it.place(0, 0)
            }
            downloadedOnlyPlaceable.fastForEach {
                it.place(0, indexingHeight)
            }
            incognitoPlaceable.fastForEach {
                it.place(0, indexingHeight + downloadedOnlyHeight)
            }
        }
    }
}

@Composable
private fun DownloadedOnlyModeBanner(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .clickable(
                onClickLabel = stringResource(MR.strings.action_disable),
                role = Role.Button,
                onClick = onClick,
            )
            .background(DownloadedOnlyBannerBackgroundColor)
            .fillMaxWidth()
            .padding(4.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(MR.strings.label_downloaded_only),
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.labelMedium,
        )
        Icon(
            imageVector = MaterialSymbols.Rounded.Close,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onTertiary,
            modifier = Modifier
                .padding(start = 4.dp)
                .size(14.dp),
        )
    }
}

@Composable
private fun IncognitoModeBanner(
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val clickModifier = if (onClick != null) {
        Modifier.clickable(
            onClickLabel = stringResource(MR.strings.action_disable),
            role = Role.Button,
            onClick = onClick,
        )
    } else {
        Modifier
    }
    Row(
        modifier = clickModifier
            .background(IncognitoModeBannerBackgroundColor)
            .fillMaxWidth()
            .padding(4.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(MR.strings.pref_incognito_mode),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.labelMedium,
        )
        if (onClick != null) {
            Icon(
                imageVector = MaterialSymbols.Rounded.Close,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(14.dp),
            )
        }
    }
}

@Composable
private fun IndexingDownloadBanner(modifier: Modifier = Modifier) {
    val density = LocalDensity.current
    Row(
        modifier = Modifier
            .background(color = IndexingBannerBackgroundColor)
            .fillMaxWidth()
            .padding(8.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
    ) {
        var textHeight by remember { mutableStateOf(0.dp) }
        CircularProgressIndicator(
            modifier = Modifier.requiredSize(textHeight),
            color = MaterialTheme.colorScheme.onSecondary,
            strokeWidth = textHeight / 8,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(MR.strings.download_notifier_cache_renewal),
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium,
            onTextLayout = {
                with(density) {
                    textHeight = it.size.height.toDp()
                }
            },
        )
    }
}

@PreviewLightDark
@Composable
private fun AppStateBannersPreview() {
    TachiyomiPreviewTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            AppStateBanners(
                downloadedOnlyMode = true,
                incognitoMode = true,
                indexing = false,
                onDownloadedOnlyClick = {},
                onIncognitoModeClick = {},
            )
            AppStateBanners(
                downloadedOnlyMode = false,
                incognitoMode = true,
                indexing = false,
                onDownloadedOnlyClick = {},
                onIncognitoModeClick = {},
            )
        }
    }
}
