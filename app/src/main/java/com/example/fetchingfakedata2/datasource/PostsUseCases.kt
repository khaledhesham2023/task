package com.example.fetchingfakedata2.datasource

class PostsUseCases {

    val repo = PostsRepo()
    suspend fun getPosts() = repo.getPosts()
    suspend fun getPostDetails(id:Long) = repo.getPostDetails(id)
}