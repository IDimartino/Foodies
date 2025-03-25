package com.foodies.home_domain.model
data class Post(
    val id: Int,
    val imageUrl: String,
    val description: String,
    var likes: Int,
    var isLiked: Boolean = false,
    val username: String,
    var comments: Int = 0,
    val carbs: Int,
    val protein: Int,
    val fat: Int
)