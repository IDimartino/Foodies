package com.foodies.home_presentation.camera_view

import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwitchCamera
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import java.io.File


@Composable
fun CameraView(
    onPhotoTaken: (String) -> Unit,
    onCameraClosed: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var lensFacing by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }
    val previewView = remember { PreviewView(context) }
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var imageCapture by remember { mutableStateOf<ImageCapture?>(null) }
    var cameraProvider: ProcessCameraProvider? = null

    // Initialize camera
    LaunchedEffect(lensFacing) {
        cameraProvider = cameraProviderFuture.get()
        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }
        val imageCaptureInstance = ImageCapture.Builder().build()
        imageCapture = imageCaptureInstance
        cameraProvider?.unbindAll()
        val cameraSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
        cameraProvider?.bindToLifecycle(lifecycleOwner, cameraSelector, preview, imageCaptureInstance)
    }

    DisposableEffect(Unit) {
        onDispose {
            cameraProvider?.unbindAll()
            onCameraClosed()
        }
    }

    // UI layout
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())

        // Switch camera button
        CameraButton(
            onClick = {
                lensFacing = if (lensFacing == CameraSelector.LENS_FACING_BACK) {
                    CameraSelector.LENS_FACING_FRONT
                } else {
                    CameraSelector.LENS_FACING_BACK
                }
            },
            icon = Icons.Default.SwitchCamera,
            contentDescription = "Switch camera",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )

        // Capture button
        CaptureButton(
            onClick = {
                val capture = imageCapture ?: return@CaptureButton
                val photosDir = File(context.filesDir, "photos")
                photosDir.mkdirs()
                val file = File(photosDir, "photo_${System.currentTimeMillis()}.jpg")
                val outputOptions = ImageCapture.OutputFileOptions.Builder(file).build()
                capture.takePicture(
                    outputOptions,
                    ContextCompat.getMainExecutor(context),
                    object : ImageCapture.OnImageSavedCallback {
                        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                            val filePath = file.absolutePath
                            onPhotoTaken(filePath) // Trigger navigation to preview
                            Toast.makeText(context, "Photo saved", Toast.LENGTH_SHORT).show()
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Toast.makeText(context, "Error capturing photo", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

/**
 * General-purpose camera button with an icon, styled like the official app.
 */
@Composable
fun CameraButton(
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color.White)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.Black
        )
    }
}

/**
 * Capture button styled as a large white circle with a black border.
 */
@Composable
fun CaptureButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(2.dp, Color.Black, CircleShape)
            .clickable(onClick = onClick)
    )
}