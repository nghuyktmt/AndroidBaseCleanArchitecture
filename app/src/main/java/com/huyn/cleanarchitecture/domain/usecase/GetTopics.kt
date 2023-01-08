package com.huyn.cleanarchitecture.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.huyn.cleanarchitecture.data.pagination.TopicPagingDataSource
import com.huyn.cleanarchitecture.domain.models.Topic
import com.huyn.cleanarchitecture.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTopics @Inject constructor(
  private val photoRepository: PhotoRepository
) : PagingUseCase<Topic, Unit>() {

  override  fun buildFlow(params: Unit): Flow<PagingData<Topic>> {
    return Pager(
      config = PagingConfig(10,5),
      pagingSourceFactory = { TopicPagingDataSource(photoRepository) }
    ).flow.map { pagingData ->
      pagingData.map {
        entity ->
        Topic.fromEntity(entity)
      }
    }

  }
}


