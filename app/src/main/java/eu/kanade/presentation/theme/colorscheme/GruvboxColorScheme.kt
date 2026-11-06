package eu.kanade.presentation.theme.colorscheme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal object GruvboxColorScheme : BaseColorScheme() {

    override val darkScheme = darkColorScheme(
        primary = Color(0xFFE0A458), // softened Gruvbox orange
        onPrimary = Color(0xFF282828),
        primaryContainer = Color(0xFF5A4630),
        onPrimaryContainer = Color(0xFFFFE6BE),
        secondary = Color(0xFF83A598), // muted blue-green
        onSecondary = Color(0xFF1D2021),
        secondaryContainer = Color(0xFF354844),
        onSecondaryContainer = Color(0xFFD8E8DE),
        tertiary = Color(0xFFB8BB6A), // softened olive
        onTertiary = Color(0xFF282828),
        tertiaryContainer = Color(0xFF45482C),
        onTertiaryContainer = Color(0xFFE9EABF),
        error = Color(0xFFFB6C5A),
        onError = Color(0xFF282828),
        errorContainer = Color(0xFF5C302B),
        onErrorContainer = Color(0xFFFFDAD2),
        background = Color(0xFF1D2021), // deep warm charcoal
        onBackground = Color(0xFFEBDBB2), // warm, readable ivory
        surface = Color(0xFF282828),
        onSurface = Color(0xFFEBDBB2),
        surfaceVariant = Color(0xFF3C3836),
        onSurfaceVariant = Color(0xFFD5C4A1),
        outline = Color(0xFFA89984),
        outlineVariant = Color(0xFF504945),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFF2E5BC),
        inverseOnSurface = Color(0xFF282828),
        inversePrimary = Color(0xFFB86F32),
        surfaceDim = Color(0xFF191B1C),
        surfaceBright = Color(0xFF3A3634),
        surfaceContainerLowest = Color(0xFF171819),
        surfaceContainerLow = Color(0xFF222424),
        surfaceContainer = Color(0xFF282828),
        surfaceContainerHigh = Color(0xFF32302F),
        surfaceContainerHighest = Color(0xFF3C3836),
    )

    override val lightScheme = lightColorScheme(
        primary = Color(0xFF9A5B16),
        onPrimary = Color(0xFFFFF8E8),
        primaryContainer = Color(0xFFF3D9A5),
        onPrimaryContainer = Color(0xFF30200D),
        secondary = Color(0xFF496F66),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFD5E6D9),
        onSecondaryContainer = Color(0xFF1E302B),
        tertiary = Color(0xFF6D702B),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFE7E8B7),
        onTertiaryContainer = Color(0xFF292B12),
        error = Color(0xFFB54532),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD2),
        onErrorContainer = Color(0xFF3B0E08),
        background = Color(0xFFF7F0D5), // soft Gruvbox paper
        onBackground = Color(0xFF3C3836),
        surface = Color(0xFFFBF5DF),
        onSurface = Color(0xFF3C3836),
        surfaceVariant = Color(0xFFE9E0C7),
        onSurfaceVariant = Color(0xFF504945),
        outline = Color(0xFF817668),
        outlineVariant = Color(0xFFD2C8AE),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF3C3836),
        inverseOnSurface = Color(0xFFF2E5BC),
        inversePrimary = Color(0xFFE0A458),
        surfaceDim = Color(0xFFE4DCC3),
        surfaceBright = Color(0xFFFFF9E8),
        surfaceContainerLowest = Color(0xFFFFFBEF),
        surfaceContainerLow = Color(0xFFFBF5DF),
        surfaceContainer = Color(0xFFF4EDD5),
        surfaceContainerHigh = Color(0xFFEDE5CC),
        surfaceContainerHighest = Color(0xFFE5DDC4),
    )
}
