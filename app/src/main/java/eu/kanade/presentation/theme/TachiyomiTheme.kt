package eu.kanade.presentation.theme

import android.content.Context
import androidx.compose.foundation.LocalOverscrollFactory
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import eu.kanade.domain.ui.model.AppTheme
import eu.kanade.presentation.theme.colorscheme.BaseColorScheme
import eu.kanade.presentation.theme.colorscheme.CatppuccinColorScheme
import eu.kanade.presentation.theme.colorscheme.GothamColorScheme
import eu.kanade.presentation.theme.colorscheme.GreenAppleColorScheme
import eu.kanade.presentation.theme.colorscheme.GruvboxColorScheme
import eu.kanade.presentation.theme.colorscheme.LavenderColorScheme
import eu.kanade.presentation.theme.colorscheme.MidnightDuskColorScheme
import eu.kanade.presentation.theme.colorscheme.MonetColorScheme
import eu.kanade.presentation.theme.colorscheme.MonochromeColorScheme
import eu.kanade.presentation.theme.colorscheme.NordColorScheme
import eu.kanade.presentation.theme.colorscheme.RetroColorScheme
import eu.kanade.presentation.theme.colorscheme.SpookyColorScheme
import eu.kanade.presentation.theme.colorscheme.StrawberryColorScheme
import eu.kanade.presentation.theme.colorscheme.TachiyomiColorScheme
import eu.kanade.presentation.theme.colorscheme.TakoColorScheme
import eu.kanade.presentation.theme.colorscheme.TealTurqoiseColorScheme
import eu.kanade.presentation.theme.colorscheme.TidalWaveColorScheme
import eu.kanade.presentation.theme.colorscheme.TokyoNightColorScheme
import eu.kanade.presentation.theme.colorscheme.YinYangColorScheme
import eu.kanade.presentation.theme.colorscheme.YokaiColorScheme
import eu.kanade.presentation.theme.colorscheme.YotsubaColorScheme
import mihon.app.di.appGraph
import tachiyomi.presentation.core.components.material.LocalReducedMotion
import tachiyomi.presentation.core.util.collectAsState

@Composable
fun TachiyomiTheme(
    appTheme: AppTheme? = null,
    amoled: Boolean? = null,
    reducedMotion: Boolean? = null,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val uiPreferences = remember { context.appGraph.uiPreferences }

    val resolvedAppTheme = appTheme ?: uiPreferences.appTheme.collectAsState().value
    val resolvedAmoled = amoled ?: uiPreferences.themeDarkAmoled.collectAsState().value
    val resolvedReducedMotion = reducedMotion ?: uiPreferences.reducedMotion.collectAsState().value

    BaseTachiyomiTheme(
        appTheme = resolvedAppTheme,
        isAmoled = resolvedAmoled,
        reducedMotion = resolvedReducedMotion,
        content = content,
    )
}

@Composable
fun TachiyomiPreviewTheme(
    appTheme: AppTheme = AppTheme.DEFAULT,
    isAmoled: Boolean = false,
    content: @Composable () -> Unit,
) = BaseTachiyomiTheme(appTheme, isAmoled, false, content)

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun BaseTachiyomiTheme(
    appTheme: AppTheme,
    isAmoled: Boolean,
    reducedMotion: Boolean,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val isDark = isSystemInDarkTheme()
    val colorScheme = remember(appTheme, isDark, isAmoled) {
        getThemeColorScheme(
            context = context,
            appTheme = appTheme,
            isDark = isDark,
            isAmoled = isAmoled,
        )
    }
    CompositionLocalProvider(
        LocalReducedMotion provides reducedMotion,
        LocalOverscrollFactory provides if (reducedMotion) null else LocalOverscrollFactory.current,
        LocalRippleConfiguration provides if (reducedMotion) null else LocalRippleConfiguration.current,
    ) {
        MaterialExpressiveTheme(
            colorScheme = colorScheme,
            motionScheme = if (reducedMotion) MotionScheme.standard() else MotionScheme.expressive(),
            content = content,
        )
    }
}

private fun getThemeColorScheme(
    context: Context,
    appTheme: AppTheme,
    isDark: Boolean,
    isAmoled: Boolean,
): ColorScheme {
    val colorScheme = if (appTheme == AppTheme.MONET) {
        MonetColorScheme(context)
    } else {
        colorSchemes.getOrDefault(appTheme, TachiyomiColorScheme)
    }
    return colorScheme.getColorScheme(
        isDark = isDark,
        isAmoled = isAmoled,
        overrideDarkSurfaceContainers = appTheme != AppTheme.MONET,
    )
}

private val colorSchemes: Map<AppTheme, BaseColorScheme> = mapOf(
    AppTheme.DEFAULT to TachiyomiColorScheme,
    AppTheme.CATPPUCCIN to CatppuccinColorScheme,
    AppTheme.GOTHAM to GothamColorScheme,
    AppTheme.GREEN_APPLE to GreenAppleColorScheme,
    AppTheme.GRUVBOX to GruvboxColorScheme,
    AppTheme.LAVENDER to LavenderColorScheme,
    AppTheme.MIDNIGHT_DUSK to MidnightDuskColorScheme,
    AppTheme.MONOCHROME to MonochromeColorScheme,
    AppTheme.NORD to NordColorScheme,
    AppTheme.RETRO to RetroColorScheme,
    AppTheme.SPOOKY to SpookyColorScheme,
    AppTheme.STRAWBERRY_DAIQUIRI to StrawberryColorScheme,
    AppTheme.TAKO to TakoColorScheme,
    AppTheme.TEALTURQUOISE to TealTurqoiseColorScheme,
    AppTheme.TIDAL_WAVE to TidalWaveColorScheme,
    AppTheme.TOKYONIGHT to TokyoNightColorScheme,
    AppTheme.YINYANG to YinYangColorScheme,
    AppTheme.YOKAI to YokaiColorScheme,
    AppTheme.YOTSUBA to YotsubaColorScheme,
)
