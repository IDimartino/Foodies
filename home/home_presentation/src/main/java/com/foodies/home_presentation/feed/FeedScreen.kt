package com.foodies.home_presentation.feed

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.foodies.coreui.LocalSpacing
import com.foodies.home_presentation.feed.components.PostItem

@Composable
fun FeedScreen(
    innerPadding: PaddingValues,
    viewModel: FeedViewModel = hiltViewModel()
) {
    val posts by viewModel.posts.collectAsStateWithLifecycle()
    val spacing = LocalSpacing.current
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = innerPadding.calculateTopPadding() + spacing.spaceLarge)
    ) {
        items(posts.size) { i ->
            val post = posts[i]
            PostItem(post, viewModel)
        }
    }
}