package com.huyn.cleanarchitecture.presentation.topics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.huyn.cleanarchitecture.R
import com.huyn.cleanarchitecture.databinding.ItemTopicBinding
import com.huyn.cleanarchitecture.domain.models.Topic
import com.huyn.cleanarchitecture.utils.extension.loadImageFitToImageView

class PagedTopicAdapter: PagingDataAdapter<Topic, PagedTopicAdapter.TopicViewHolder>(
  object :DiffUtil.ItemCallback<Topic>(){
    override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
      return oldItem == newItem
    }
  }
) {

  var  onTopicSelected: ((Topic) -> Unit)? = null

  override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
    val item = getItem(position)
    holder.binding.topic = item
    onTopicSelected?.let {
      onClick ->
      holder.binding.rootLayout.setOnClickListener {
        item?.let {
          onClick(it)
        }
      }
    }
    holder.binding.executePendingBindings()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
    return TopicViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_topic, parent, false))
  }

  class TopicViewHolder (val binding: ItemTopicBinding): RecyclerView.ViewHolder(binding.root)

}

@BindingAdapter("bindTopicCover")
fun AppCompatImageView.bindTopicCover(cover: String) {
  loadImageFitToImageView(cover)
}