package com.huyn.cleanarchitecture.data.repo

import com.huyn.cleanarchitecture.domain.repository.UserRepository
import com.huyn.cleanarchitecture.data.entity.UserEntity
import com.huyn.cleanarchitecture.data.remote.Api
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: Api) : UserRepository {
    override suspend fun getUser(): List<UserEntity>  = api.getUsers()
}