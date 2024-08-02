package com.dinesh.m3theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import hct.Hct
import scheme.SchemeContent
import scheme.SchemeExpressive
import scheme.SchemeFidelity
import scheme.SchemeFruitSalad
import scheme.SchemeMonochrome
import scheme.SchemeNeutral
import scheme.SchemeRainbow
import scheme.SchemeTonalSpot
import scheme.SchemeVibrant

enum class PaletteStyle {
    TonalSpot,
    Neutral,
    Vibrant,
    Expressive,
    Rainbow,
    FruitSalad,
    Monochrome,
    Fidelity,
    Content
}

object ColorScheme {
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
            background = Color(scheme.background),
            error = Color(scheme.error),
            errorContainer = Color(scheme.errorContainer),
            inverseOnSurface = Color(scheme.inverseOnSurface),
            inversePrimary = Color(scheme.inversePrimary),
            inverseSurface = Color(scheme.inverseSurface),
            onBackground = Color(scheme.onBackground),
            onError = Color(scheme.onError),
            onErrorContainer = Color(scheme.onErrorContainer),
            onPrimary = Color(scheme.onPrimary),
            onPrimaryContainer = Color(scheme.onPrimaryContainer),
            onSecondary = Color(scheme.onSecondary),
            onSecondaryContainer = Color(scheme.onSecondaryContainer),
            onSurface = Color(scheme.onSurface),
            onSurfaceVariant = Color(scheme.onSurfaceVariant),
            onTertiary = Color(scheme.onTertiary),
            onTertiaryContainer = Color(scheme.onTertiaryContainer),
            outline = Color(scheme.outline),
            outlineVariant = Color(scheme.outlineVariant),
            primary = Color(scheme.primary),
            primaryContainer = Color(scheme.primaryContainer),
            scrim = Color(scheme.scrim),
            secondary = Color(scheme.secondary),
            secondaryContainer = Color(scheme.secondaryContainer),
            surface = Color(scheme.surface),
            surfaceBright = Color(scheme.surfaceBright),
            surfaceContainer = Color(scheme.surfaceContainer),
            surfaceContainerLow = Color(scheme.surfaceContainerLow),
            surfaceContainerLowest = Color(scheme.surfaceContainerLowest),
            surfaceContainerHigh = Color(scheme.surfaceContainerHigh),
            surfaceContainerHighest = Color(scheme.surfaceContainerHighest),
            surfaceDim = Color(scheme.surfaceDim),
            surfaceTint = Color(scheme.surfaceTint),
            surfaceVariant = Color(scheme.surfaceVariant),
            tertiary = Color(scheme.tertiary),
            tertiaryContainer = Color(scheme.tertiaryContainer),
        )
    }
}