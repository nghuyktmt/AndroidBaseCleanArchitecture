package com.huyn.cleanarchitecture.presentation.topics.detail

import androidx.paging.PagingData
import com.huyn.cleanarchitecture.domain.models.Photo
import com.huyn.cleanarchitecture.domain.models.Topic
import com.huyn.cleanarchitecture.domain.usecase.GetTopicPhotos
import com.huyn.cleanarchitecture.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TopicDetailViewModel @Inject constructor(private val getTopicPhotos: GetTopicPhotos): BaseViewModel() {

  lateinit var topic: Topic
  private var currentPage = 1

  /*private val _photos = MutableSharedFlow<State<List<Photo>>>()
  val photos: Flow<State<List<Photo>>> = _photos*/

  val photos: Flow<PagingData<Photo>> by lazy {
    getTopicPhotos.invoke(params = GetTopicPhotos.Params(topic.id))
  }

  fun initTopicData(topic: Topic) {
    this.topic = topic
  }

}