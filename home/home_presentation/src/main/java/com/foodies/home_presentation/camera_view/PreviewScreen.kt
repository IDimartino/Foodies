package com.foodies.home_presentation.camera_view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import java.io.File

@Composable
fun PreviewScreen(
    filePath: String,
    onShare: () -> Unit
) {
    val painter = rememberAsyncImagePainter(model = File(filePath))
    var comment by remember { mutableStateOf("") }
    val context = LocalContext.current

    val message = stringResource(com.foodies.core.R.string.preview_posted_message)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display captured photo
        Image(
            painter = painter,
            contentDescription = "Captured photo",
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        // Comment input
        TextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text(stringResource(com.foodies.core.R.string.preview_add_comment)) },
            modifier = Modifier.fillMaxWidth()
        )
        // Post button
        Button(
            onClick = {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                onShare()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(stringResource(com.foodies.core.R.string.share))
        }
    }
}