package com.example.fetchingfakedata2.datasource

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsUseCases @Inject constructor(private val repo: PostsRepo) {

    suspend fun getPosts() = repo.getPosts()
    suspend fun getPostDetails(id:Long) = repo.getPostDetails(id)
}