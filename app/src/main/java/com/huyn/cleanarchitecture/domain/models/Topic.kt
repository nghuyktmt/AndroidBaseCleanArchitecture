package com.huyn.cleanarchitecture.domain.models

import com.huyn.cleanarchitecture.data.entity.TopicEntity
import java.io.Serializable

data class Topic(
    val id: String,
    val title: String,
    val description: String,
    val previewImage: String
) : Serializable {
    companion object {
        fun fromEntity(entity: TopicEntity): Topic {
            return Topic(
                id = entity.id ?: "",
                title = entity.title ?: "",
                description = entity.description ?: "",
                previewImage = entity.coverPhoto?.urls?.full ?: ""
            )
        }
    }
}
