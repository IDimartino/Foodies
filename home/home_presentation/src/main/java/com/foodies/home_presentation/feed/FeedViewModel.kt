package com.foodies.home_presentation.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodies.home_domain.model.Post
import com.foodies.home_domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow(repository.getPosts())
    val posts = _posts.asStateFlow()

    fun onLikeClick(post: Post) {
        viewModelScope.launch {
            val newPost = post.copy(
                likes = if(post.isLiked) post.likes -1 else post.likes + 1,
                isLiked = !post.isLiked
            )
            repository.addLike(newPost)
            _posts.value = repository.getPosts()
        }
    }
}