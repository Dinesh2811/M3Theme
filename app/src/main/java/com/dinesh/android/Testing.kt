package com.dinesh.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import com.dinesh.m3theme.hct.Hct
import com.dinesh.m3theme.scheme.SchemeContent
import com.dinesh.m3theme.scheme.SchemeExpressive
import com.dinesh.m3theme.scheme.SchemeFidelity
import com.dinesh.m3theme.scheme.SchemeFruitSalad
import com.dinesh.m3theme.scheme.SchemeMonochrome
import com.dinesh.m3theme.scheme.SchemeNeutral
import com.dinesh.m3theme.scheme.SchemeRainbow
import com.dinesh.m3theme.scheme.SchemeTonalSpot
import com.dinesh.m3theme.scheme.SchemeVibrant

@Suppress("NOTHING_TO_INLINE")
private inline fun Int.toColor(): Color = Color(this)

private val TAG = "log_" + Testing::class.java.name.split(Testing::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class Testing: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val keyColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                colorResource(id = android.R.color.system_accent1_500)
            } else {
                Color(0xFF007FAC)
            }

            MaterialTheme(
                colorScheme = dynamicColorScheme(
                    keyColor = Color(0xFF007FAC),
                    isDark = isSystemInDarkTheme()
                )
            ) {

            }
        }
    }

    @Stable
    fun dynamicColorScheme(
        keyColor: Color,
        isDark: Boolean,
        style: PaletteStyle = PaletteStyle.TonalSpot,
        contrastLevel: Double = 0.0
    ): ColorScheme {
        val hct = Hct.fromInt(keyColor.toArgb())
        val scheme = when (style) {
            PaletteStyle.TonalSpot -> SchemeTonalSpot(hct, isDark, contrastLevel)
            PaletteStyle.Neutral -> SchemeNeutral(hct, isDark, contrastLevel)
            PaletteStyle.Vibrant -> SchemeVibrant(hct, isDark, contrastLevel)
            PaletteStyle.Expressive -> SchemeExpressive(hct, isDark, contrastLevel)
            PaletteStyle.Rainbow -> SchemeRainbow(hct, isDark, contrastLevel)
            PaletteStyle.FruitSalad -> SchemeFruitSalad(hct, isDark, contrastLevel)
            PaletteStyle.Monochrome -> SchemeMonochrome(hct, isDark, contrastLevel)
            PaletteStyle.Fidelity -> SchemeFidelity(hct, isDark, contrastLevel)
            PaletteStyle.Content -> SchemeContent(hct, isDark, contrastLevel)
        }

        return ColorScheme(
            background = scheme.background.toColor(),
            error = scheme.error.toColor(),
            errorContainer = scheme.errorContainer.toColor(),
            inverseOnSurface = scheme.inverseOnSurface.toColor(),
            inversePrimary = scheme.inversePrimary.toColor(),
            inverseSurface = scheme.inverseSurface.toColor(),
            onBackground = scheme.onBackground.toColor(),
            onError = scheme.onError.toColor(),
            onErrorContainer = scheme.onErrorContainer.toColor(),
            onPrimary = scheme.onPrimary.toColor(),
            onPrimaryContainer = scheme.onPrimaryContainer.toColor(),
            onSecondary = scheme.onSecondary.toColor(),
            onSecondaryContainer = scheme.onSecondaryContainer.toColor(),
            onSurface = scheme.onSurface.toColor(),
            onSurfaceVariant = scheme.onSurfaceVariant.toColor(),
            onTertiary = scheme.onTertiary.toColor(),
            onTertiaryContainer = scheme.onTertiaryContainer.toColor(),
            outline = scheme.outline.toColor(),
            outlineVariant = scheme.outlineVariant.toColor(),
            primary = scheme.primary.toColor(),
            primaryContainer = scheme.primaryContainer.toColor(),
            scrim = scheme.scrim.toColor(),
            secondary = scheme.secondary.toColor(),
            secondaryContainer = scheme.secondaryContainer.toColor(),
            surface = scheme.surface.toColor(),
            surfaceBright = scheme.surfaceBright.toColor(),
            surfaceContainer = scheme.surfaceContainer.toColor(),
            surfaceContainerLow = scheme.surfaceContainerLow.toColor(),
            surfaceContainerLowest = scheme.surfaceContainerLowest.toColor(),
            surfaceContainerHigh = scheme.surfaceContainerHigh.toColor(),
            surfaceContainerHighest = scheme.surfaceContainerHighest.toColor(),
            surfaceDim = scheme.surfaceDim.toColor(),
            surfaceTint = scheme.surfaceTint.toColor(),
            surfaceVariant = scheme.surfaceVariant.toColor(),
            tertiary = scheme.tertiary.toColor(),
            tertiaryContainer = scheme.tertiaryContainer.toColor(),
        )
    }
}
