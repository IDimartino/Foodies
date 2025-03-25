package com.foodies.home_domain.repository

import com.foodies.home_domain.model.Post

interface PostRepository {
    fun getPosts(): List<Post>
    fun addLike(post: Post)
}