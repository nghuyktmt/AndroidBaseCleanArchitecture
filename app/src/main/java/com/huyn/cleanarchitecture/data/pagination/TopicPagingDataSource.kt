package com.huyn.cleanarchitecture.data.pagination

import androidx.paging.PagingSource
import com.huyn.cleanarchitecture.data.entity.TopicEntity
import com.huyn.cleanarchitecture.domain.repository.PhotoRepository

class TopicPagingDataSource constructor(
    private val photoRepository: PhotoRepository
) : PagingSource<Int, TopicEntity>() {
  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopicEntity> {
    try {
      val page = params.key ?: 1
      val data = photoRepository.getTopics(page)
      val nextPage = if (data.isNotEmpty()) {
        page + 1
      } else {
        null
      }
      return LoadResult.Page(
        data = data,
        nextKey = nextPage,
        prevKey = null
      )
    } catch (e: Exception) {
      return LoadResult.Error(e)
    }
  }

}