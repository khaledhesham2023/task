package com.example.fetchingfakedata2.datasource

class PostsRepo {
    suspend fun getPosts() = PostsApiService.postsApi.getPosts()

    suspend fun getPostDetails(id:Long) = PostsApiService.postsApi.getPostDetails(id)
}