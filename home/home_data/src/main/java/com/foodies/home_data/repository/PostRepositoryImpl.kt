package com.foodies.home_data.repository

import com.foodies.home_data.remote.dto.PostProvider
import com.foodies.home_domain.model.Post
import com.foodies.home_domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(

) : PostRepository {

    private val posts = PostProvider.getPosts().toMutableList()

    override fun getPosts(): List<Post> {
        return posts.toList()
    }

    override fun addLike(post: Post) {
        val postToUpdate = posts.find { it.id == post.id } ?: return
        postToUpdate.likes = post.likes
        postToUpdate.isLiked = post.isLiked
    }

}