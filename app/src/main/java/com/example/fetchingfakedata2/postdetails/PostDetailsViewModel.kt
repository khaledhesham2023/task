package com.example.fetchingfakedata2.postdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingfakedata2.datasource.PostsUseCases
import com.example.fetchingfakedata2.model.Post
import kotlinx.coroutines.launch

class PostDetailsViewModel: ViewModel() {

    val useCases = PostsUseCases()

    private var _getPostDetailsLiveData = MutableLiveData<Post>()
    val getPostDetailsLiveData:LiveData<Post>
        get() = _getPostDetailsLiveData

    fun getPostDetails(id:Long) = viewModelScope.launch {
        _getPostDetailsLiveData.value = useCases.getPostDetails(id)
    }
}