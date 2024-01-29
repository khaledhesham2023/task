package com.example.fetchingfakedata2.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingfakedata2.datasource.PostsUseCases
import com.example.fetchingfakedata2.model.Post
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {

    private val postsUseCases = PostsUseCases()

    private var _getPostsLiveData = MutableLiveData<List<Post>>()
    val getPostsLiveData:LiveData<List<Post>>
        get() = _getPostsLiveData

    fun getPosts(){
        viewModelScope.launch {
            _getPostsLiveData.value = postsUseCases.getPosts()
        }
    }
}