package com.huyn.cleanarchitecture.domain.usecase

import com.huyn.cleanarchitecture.data.entity.State
import com.huyn.cleanarchitecture.data.entity.UserEntity
import com.huyn.cleanarchitecture.domain.models.User
import com.huyn.cleanarchitecture.domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

class GetUserList @Inject constructor(
  private val userRepository: UserRepository
) : UseCase<List<User>, Unit>() {

  override fun buildFlow(param: Unit): Flow<State<List<User>>> {
    val firstUserCollectionFlow = flow {
      emit(userRepository.getUser())
    }
    val secondUserCollectionFlow = flow {
      emit(userRepository.getUser())
    }
    return firstUserCollectionFlow.zip(secondUserCollectionFlow) { users1, users2 ->
      val all = mutableListOf<UserEntity>()
      all.addAll(users1)
      all.addAll(users2)
      all.toList().map {
        User.fromEntity(it)
      }
    }.flatMapMerge {
      flow<State<List<User>>> {
        delay(2000)
        emit(State.DataState(it))
      }
    }
  }

}

