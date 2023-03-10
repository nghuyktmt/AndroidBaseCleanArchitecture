package com.huyn.cleanarchitecture.data.remote

import com.huyn.cleanarchitecture.data.entity.PhotoEntity
import com.huyn.cleanarchitecture.data.entity.TopicEntity
import com.huyn.cleanarchitecture.data.entity.UserEntity
import okhttp3.ResponseBody
import retrofit2.http.*

interface Api {
    @GET("users")
    suspend fun getUsers(): List<UserEntity>

    @GET("topics")
    suspend fun getTopics(@Query("page") page: Int): List<TopicEntity>

    @GET("topics/{topicId}/photos")
    suspend fun getTopicPhotos(@Path("topicId") topicId: String, @Query("page") page: Int, @Query("per_page") perPage: Int = 20): List<PhotoEntity>

    @Streaming
    @GET
    suspend fun downloadPhoto(@Url url: String): ResponseBody
}