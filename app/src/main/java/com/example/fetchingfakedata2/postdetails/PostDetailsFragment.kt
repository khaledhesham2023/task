package com.example.fetchingfakedata2.postdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.fetchingfakedata2.R
import com.example.fetchingfakedata2.base.BaseFragment
import com.example.fetchingfakedata2.databinding.FragmentPostDetailsBinding
import com.example.fetchingfakedata2.databinding.FragmentPostsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : BaseFragment<FragmentPostDetailsBinding,PostDetailsViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_post_details
    override val viewModelClass: Class<PostDetailsViewModel>
        get() = PostDetailsViewModel::class.java

    private var postId:Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postId = PostDetailsFragmentArgs.fromBundle(requireArguments()).postId
        viewModel.getPostDetails(postId)
        viewModel.getPostDetailsLiveData.observe(viewLifecycleOwner, Observer {
         viewBinding.title.text = "User #${it.userId} : ${it.title}"
         viewBinding.body.text = it.body
        })
    }

}