package com.example.fetchingfakedata2.datasource

import com.example.fetchingfakedata2.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PostsApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostDetails(@Path("id") id:Long): Post

}

object PostsApiService {
    val postsApi: PostsApi by lazy {
        retrofit.create(PostsApi::class.java)
    }
}