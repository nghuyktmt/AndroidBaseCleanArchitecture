package com.huyn.cleanarchitecture.presentation.topics.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.huyn.cleanarchitecture.R
import com.huyn.cleanarchitecture.databinding.ItemTopicDetailBinding
import com.huyn.cleanarchitecture.domain.models.Topic

class HeaderAdapter(val topic: Topic) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    class HeaderViewHolder(val binding: ItemTopicDetailBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HeaderViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_topic_detail,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.binding.topic = topic
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = 1

}