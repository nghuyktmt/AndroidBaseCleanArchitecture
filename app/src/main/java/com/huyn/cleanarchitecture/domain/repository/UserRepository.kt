package com.huyn.cleanarchitecture.domain.repository

import com.huyn.cleanarchitecture.data.entity.UserEntity

interface UserRepository {

   suspend fun getUser(): List<UserEntity>

}