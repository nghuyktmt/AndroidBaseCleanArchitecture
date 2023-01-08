package com.huyn.cleanarchitecture.domain.models

import com.huyn.cleanarchitecture.data.entity.UserEntity

data class User(val name: String) {
  companion object {
    fun fromEntity(entity: UserEntity) = User(entity.name)
  }
}