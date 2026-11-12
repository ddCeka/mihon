package eu.kanade.presentation.theme.colorscheme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal object YokaiColorScheme : BaseColorScheme() {

    override val darkScheme = darkColorScheme(
        primary = Color(0xFFE58A8A), // Desaturated soft crimson
        onPrimary = Color(0xFF2B1515),
        primaryContainer = Color(0xFF542828),
        onPrimaryContainer = Color(0xFFF5D6D6),
        secondary = Color(0xFFC4A1CC), // Muted twilight lavender
        onSecondary = Color(0xFF261829),
        secondaryContainer = Color(0xFF3E2942),
        onSecondaryContainer = Color(0xFFEBD9EF),
        tertiary = Color(0xFF939EC9), // Softened slate indigo
        onTertiary = Color(0xFF1A1E2E),
        tertiaryContainer = Color(0xFF2B324A),
        onTertiaryContainer = Color(0xFFDCE1F5),
        error = Color(0xFFE59890),
        onError = Color(0xFF331411),
        errorContainer = Color(0xFF592620),
        onErrorContainer = Color(0xFFF7DCD9),
        background = Color(0xFF171412), // Lifted warm charcoal
        onBackground = Color(0xFFDCD3C9), // Low-glare warm cream
        surface = Color(0xFF1E1A17), // Soft espresso surface
        onSurface = Color(0xFFDCD3C9),
        surfaceVariant = Color(0xFF2E2824),
        onSurfaceVariant = Color(0xFFB8ACA0),
        outline = Color(0xFF82766B),
        outlineVariant = Color(0xFF3D352F),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFDCD3C9),
        inverseOnSurface = Color(0xFF1E1A17),
        inversePrimary = Color(0xFF9E3B3B),
        surfaceDim = Color(0xFF14110F),
        surfaceBright = Color(0xFF362F2B),
        surfaceContainerLowest = Color(0xFF120F0E),
        surfaceContainerLow = Color(0xFF1A1714),
        surfaceContainer = Color(0xFF1E1A17),
        surfaceContainerHigh = Color(0xFF26211E),
        surfaceContainerHighest = Color(0xFF2E2824),
    )

    override val lightScheme = lightColorScheme(
        primary = Color(0xFF9E3B3B), // Warm terracotta crimson
        onPrimary = Color(0xFFFAF3EB),
        primaryContainer = Color(0xFFEED3CE),
        onPrimaryContainer = Color(0xFF3B1414),
        secondary = Color(0xFF634078), // Dusty plum
        onSecondary = Color(0xFFFAF3EB),
        secondaryContainer = Color(0xFFE5D7EC),
        onSecondaryContainer = Color(0xFF261430),
        tertiary = Color(0xFF3B4578), // Muted twilight blue
        onTertiary = Color(0xFFFAF3EB),
        tertiaryContainer = Color(0xFFD7DCF0),
        onTertiaryContainer = Color(0xFF141933),
        error = Color(0xFFA63A32),
        onError = Color(0xFFFAF3EB),
        errorContainer = Color(0xFFF2D4D0),
        onErrorContainer = Color(0xFF3B110E),
        background = Color(0xFFEDE4D5), // Aged sepia parchment
        onBackground = Color(0xFF2E2925), // Deep warm charcoal ink
        surface = Color(0xFFF3ECE0), // Matte warm paper
        onSurface = Color(0xFF2E2925),
        surfaceVariant = Color(0xFFE0D5C5),
        onSurfaceVariant = Color(0xFF524942),
        outline = Color(0xFF82766A),
        outlineVariant = Color(0xFFC9BCAE),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2E2925),
        inverseOnSurface = Color(0xFFEDE4D5),
        inversePrimary = Color(0xFFE58A8A),
        surfaceDim = Color(0xFFDCD1C0),
        surfaceBright = Color(0xFFF7F1E6),
        surfaceContainerLowest = Color(0xFFFAF5EC),
        surfaceContainerLow = Color(0xFFF3ECE0),
        surfaceContainer = Color(0xFFECE3D4),
        surfaceContainerHigh = Color(0xFFE5DBC9),
        surfaceContainerHighest = Color(0xFFDED2BF),
    )
}
