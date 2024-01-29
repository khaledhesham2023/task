package com.example.fetchingfakedata2.posts

import android.content.Context
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.fetchingfakedata2.R
import com.example.fetchingfakedata2.databinding.ItemPostBinding
import com.example.fetchingfakedata2.model.Post
import com.example.fetchingfakedata2.utils.PostUtils

class PostsAdapter(
    var oldData: MutableList<Post>,
    private val onPostClickListener: OnPostClickListener
) : Adapter<PostsAdapter.PostsViewHolder>() {

    inner class PostsViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onPostClickListener.onPostClicked(oldData[layoutPosition].id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(getItemDataBinding(parent.context, R.layout.item_post, parent))
    }

    override fun getItemCount() = oldData.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.binding.post = oldData[position]
    }

    private fun getItemDataBinding(
        context: Context,
        layout: Int,
        container: ViewGroup
    ): ItemPostBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(context), layout, container, false)
    }

    fun updateDataSet(updatedList: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(PostUtils(oldData, updatedList))
        oldData.clear()
        oldData.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }
}