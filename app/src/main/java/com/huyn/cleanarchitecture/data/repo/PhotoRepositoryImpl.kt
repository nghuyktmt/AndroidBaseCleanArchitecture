package com.huyn.cleanarchitecture.data.repo

import android.content.Context
import com.huyn.cleanarchitecture.domain.repository.PhotoRepository
import com.huyn.cleanarchitecture.data.remote.Api
import com.huyn.cleanarchitecture.utils.extension.FileUtils
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val api: Api, private val context: Context) :
  PhotoRepository {

  override suspend fun getTopics(page: Int) = api.getTopics(page)

  override suspend fun getTopicDetail(topicId: String, page: Int) = api.getTopicPhotos(topicId, page = page)

  override suspend fun downloadPhoto(url: String, fileName: String): String {
    val body = api.downloadPhoto(url)
    return  FileUtils.saveFile(context, body, fileName)
  }
}