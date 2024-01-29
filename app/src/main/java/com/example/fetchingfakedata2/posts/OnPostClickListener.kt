package com.example.fetchingfakedata2.posts

import com.example.fetchingfakedata2.model.Post

interface OnPostClickListener {
    fun onPostClicked(postId: Long)
}