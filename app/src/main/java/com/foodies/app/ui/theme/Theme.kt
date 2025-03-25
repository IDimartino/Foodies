package com.foodies.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.foodies.coreui.BrightBlue
import com.foodies.coreui.DarkBlue
import com.foodies.coreui.DarkGray
import com.foodies.coreui.Dimensions
import com.foodies.coreui.LightGray
import com.foodies.coreui.LocalSpacing
import com.foodies.coreui.MediumGray
import com.foodies.coreui.Orange
import com.foodies.coreui.TextWhite

private val DarkColorPalette = darkColors(
    primary = BrightBlue,
    primaryVariant = DarkBlue,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = BrightBlue,
    primaryVariant = DarkBlue,
    secondary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

@Composable
fun FoodiesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}