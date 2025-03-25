package com.foodies.home_presentation.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    @StringRes val labelResId: Int,
    val icon: ImageVector
) {
    object Feed : BottomNavItem("feed", com.foodies.core.R.string.feed, Icons.Default.Feed)
    object Photo : BottomNavItem("photo", com.foodies.core.R.string.photo, Icons.Default.Camera)
    object Tracker : BottomNavItem("tracker", com.foodies.core.R.string.tracker, Icons.Default.Place)
    object Profile : BottomNavItem("profile", com.foodies.core.R.string.profile, Icons.Default.AccountCircle)
}