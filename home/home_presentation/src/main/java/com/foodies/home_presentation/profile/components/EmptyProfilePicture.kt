package com.foodies.home_presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.foodies.coreui.LocalSpacing

@Composable
fun EmptyProfilePicture(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(Color.Gray.copy(alpha = 0.3f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Profile Picture",
            tint = Color.White,
            modifier = Modifier.size(spacing.spaceLarge)
        )
    }
}