package com.foodies.home_presentation.feed.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.foodies.coreui.LocalSpacing
import com.foodies.home_domain.model.Post
import com.foodies.home_presentation.feed.FeedViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex

@Composable
fun PostItem(
    post: Post,
    viewModel: FeedViewModel
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.spaceMedium)
    ) {
        Column {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(model = post.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .zIndex(2f)
                        .align(Alignment.BottomEnd)
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(spacing.spaceSmall)
                ) {
                    Text(
                        text = "C: ${post.carbs}",
                        style = MaterialTheme.typography.body2,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = spacing.spaceExtraSmall)
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                    Text(
                        text = "P: ${post.protein}",
                        style = MaterialTheme.typography.body2,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = spacing.spaceExtraSmall)
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                    Text(
                        text = "F: ${post.fat}",
                        style = MaterialTheme.typography.body2,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = spacing.spaceExtraSmall)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(spacing.spaceSmall)
            ) {
                // Display the username
                Text(
                    text = post.username,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(modifier = Modifier.padding(spacing.spaceSmall)) {
                Text(
                    text = post.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { viewModel.onLikeClick(post) },
                    ) {
                        Icon(
                            imageVector = if (post.isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Like",
                            tint = if (post.isLiked) Color.Red else MaterialTheme.colors.primary,
                            modifier = Modifier.size(spacing.spaceLarge)
                        )
                    }
                    Text(
                        text = post.likes.toString(),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        IconButton(
                            onClick = {
                                Log.d(
                                    "PostItem",
                                    "Comment clicked for post ${post.id}"
                                )
                            }) {
                            Icon(
                                imageVector = Icons.Filled.AddComment,
                                contentDescription = "Comment",
                                modifier = Modifier.size(spacing.spaceMediumLarge)
                            )
                        }
                        Text(
                            text = post.comments.toString(),
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                    IconButton(onClick = {
                        Log.d(
                            "PostItem",
                            "Share clicked for post ${post.id}"
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            modifier = Modifier.size(spacing.spaceMediumLarge)
                        )
                    }
                }
            }
        }
    }
}