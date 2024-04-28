package com.komparo.helpfullinks.di

import com.komparo.helpfullinks.data.dao.OneDao
import com.komparo.helpfullinks.domain.repositories.OneRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

//    @Singleton
//    @Provides
//    fun provideOneRepository(oneDao : OneDao): OneRepository {
//        return  OneRepositoryImpl(oneDao)
//    }

}
