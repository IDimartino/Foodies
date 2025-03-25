package com.foodies.home_presentation.camera_view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.foodies.coreui.LocalSpacing
import com.foodies.home_presentation.profile.ProfileViewModel

@Composable
fun CameraScreen(
    onPhotoTaken: (String) -> Unit,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier
            .padding(top = spacing.spaceExtraLarge)
    ) {
        CameraView(onPhotoTaken) {}
    }
}