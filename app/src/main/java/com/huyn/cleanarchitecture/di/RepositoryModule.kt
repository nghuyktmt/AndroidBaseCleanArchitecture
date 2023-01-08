package com.huyn.cleanarchitecture.di

import android.content.Context
import com.huyn.cleanarchitecture.domain.repository.PhotoRepository
import com.huyn.cleanarchitecture.domain.repository.UserRepository
import com.huyn.cleanarchitecture.data.remote.Api
import com.huyn.cleanarchitecture.data.repo.PhotoRepositoryImpl
import com.huyn.cleanarchitecture.data.repo.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(api: Api): UserRepository = UserRepositoryImpl(api)

    @Provides
    @Singleton
    fun providePhotoRepository(@ApplicationContext context: Context, api: Api): PhotoRepository = PhotoRepositoryImpl(api, context)
}