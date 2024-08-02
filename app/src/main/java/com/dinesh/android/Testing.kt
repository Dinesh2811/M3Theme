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
import com.dinesh.m3theme.ColorScheme.dynamicColorScheme
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

}
