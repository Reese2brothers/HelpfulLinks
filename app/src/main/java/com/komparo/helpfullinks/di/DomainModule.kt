package com.komparo.helpfullinks.di

import com.komparo.helpfullinks.domain.repositories.OneRepository
import com.komparo.helpfullinks.domain.usecase.OneDeleteAllUseCase
import com.komparo.helpfullinks.domain.usecase.OneGetTitleUseCase
import com.komparo.helpfullinks.domain.usecase.OneInsertUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideOneDeleteAllUseCase(oneRepository : OneRepository): OneDeleteAllUseCase {
        return  OneDeleteAllUseCase(oneRepository = oneRepository)
    }

    @Provides
    fun provideOneInsertUseCase(oneRepository : OneRepository): OneInsertUseCase {
        return  OneInsertUseCase(oneRepository = oneRepository)
    }

    @Provides
    fun provideOneGetTitleUseCase(oneRepository : OneRepository): OneGetTitleUseCase {
        return  OneGetTitleUseCase(oneRepository = oneRepository)
    }
}