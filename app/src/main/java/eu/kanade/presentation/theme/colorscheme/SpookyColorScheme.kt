package eu.kanade.presentation.theme.colorscheme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal object SpookyColorScheme : BaseColorScheme() {

    override val darkScheme = darkColorScheme(
        primary = Color(0xFFCF7F42), // muted pumpkin orange
        onPrimary = Color(0xFF140D09),
        primaryContainer = Color(0xFF5B2E1A),
        onPrimaryContainer = Color(0xFFF7D8B3),
        secondary = Color(0xFF9A6CC4), // eerie purple
        onSecondary = Color(0xFF120C1C),
        secondaryContainer = Color(0xFF341F43),
        onSecondaryContainer = Color(0xFFE9D9FF),
        tertiary = Color(0xFF6B8F67), // mossy green
        onTertiary = Color(0xFF07120A),
        tertiaryContainer = Color(0xFF22432D),
        onTertiaryContainer = Color(0xFFDFF5D9),
        error = Color(0xFFCF6679),
        onError = Color(0xFF140D09),
        errorContainer = Color(0xFF5A202A),
        onErrorContainer = Color(0xFFFFD6DC),
        background = Color(0xFF111111), // deep charcoal, easier on eyes
        onBackground = Color(0xFFEDE0D2), // warm ivory for text
        surface = Color(0xFF191614),
        onSurface = Color(0xFFEDE0D2),
        surfaceVariant = Color(0xFF2A241F),
        onSurfaceVariant = Color(0xFFD8C9B6),
        outline = Color(0xFF8E7F70),
        outlineVariant = Color(0xFF3A312F),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFF1E4D7),
        inverseOnSurface = Color(0xFF171311),
        inversePrimary = Color(0xFFB86A33),
        surfaceDim = Color(0xFF121111),
        surfaceBright = Color(0xFF352D2A),
        surfaceContainerLowest = Color(0xFF0E0E0E),
        surfaceContainerLow = Color(0xFF171412),
        surfaceContainer = Color(0xFF1D1A18),
        surfaceContainerHigh = Color(0xFF292321),
        surfaceContainerHighest = Color(0xFF332D2A),
    )

    override val lightScheme = lightColorScheme(
        primary = Color(0xFF9A4D1E),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFF3D6B3),
        onPrimaryContainer = Color(0xFF2A170D),
        secondary = Color(0xFF6A4B92),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFE6D9F5),
        onSecondaryContainer = Color(0xFF20162E),
        tertiary = Color(0xFF4C7558),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFD9EAD7),
        onTertiaryContainer = Color(0xFF12261A),
        error = Color(0xFFB63946),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFE4E8),
        onErrorContainer = Color(0xFF3F1015),
        background = Color(0xFFF6F0E9), // soft warm paper
        onBackground = Color(0xFF1E1A17),
        surface = Color(0xFFF9F4EE),
        onSurface = Color(0xFF1E1A17),
        surfaceVariant = Color(0xFFEAE0D6),
        onSurfaceVariant = Color(0xFF4F433B),
        outline = Color(0xFF8A776C),
        outlineVariant = Color(0xFFD3C3B7),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2C2624),
        inverseOnSurface = Color(0xFFF6F1EA),
        inversePrimary = Color(0xFFCF7F42),
        surfaceDim = Color(0xFFE8DFD4),
        surfaceBright = Color(0xFFFFF9F4),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF9F3EE),
        surfaceContainer = Color(0xFFF4EDE5),
        surfaceContainerHigh = Color(0xFFEDE6DE),
        surfaceContainerHighest = Color(0xFFE5DDD4),
    )
}
