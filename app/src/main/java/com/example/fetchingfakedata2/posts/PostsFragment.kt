package com.example.fetchingfakedata2.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.fetchingfakedata2.R
import com.example.fetchingfakedata2.base.BaseFragment
import com.example.fetchingfakedata2.databinding.FragmentPostsBinding
import com.example.fetchingfakedata2.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : BaseFragment<FragmentPostsBinding, PostsViewModel>(),OnPostClickListener {
    override val layout: Int
        get() = R.layout.fragment_posts
    override val viewModelClass: Class<PostsViewModel>
        get() = PostsViewModel::class.java

    private lateinit var adapter: PostsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PostsAdapter(mutableListOf(Post(0,0,"Hello amanda","Hi there"),Post(1,1,"Zack", "Professional")),this)
        viewBinding.posts.adapter = adapter
        viewModel.getPosts()
        viewModel.getPostsLiveData.observe(viewLifecycleOwner, Observer {
            adapter.updateDataSet(it)
        })

    }

    override fun onPostClicked(postId: Long) {
        findNavController().navigate(PostsFragmentDirections.actionPostsFragmentToPostDetailsFragment(postId))
    }

}