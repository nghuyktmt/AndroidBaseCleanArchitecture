package com.huyn.cleanarchitecture.domain.repository

import com.huyn.cleanarchitecture.data.entity.PhotoEntity
import com.huyn.cleanarchitecture.data.entity.TopicEntity

interface PhotoRepository {
  suspend fun getTopics(page: Int): List<TopicEntity>
  suspend fun getTopicDetail(topicId: String, page: Int): List<PhotoEntity>
  suspend fun downloadPhoto(url: String, fileName: String): String
}