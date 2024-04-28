package com.komparo.helpfullinks.di

import android.content.Context
import com.komparo.helpfullinks.data.AppDatabase
import com.komparo.helpfullinks.data.dao.OneDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(context = appContext)
    }

    @Singleton
    @Provides
    fun provideOneDao(appDatabase : AppDatabase): OneDao {
        return appDatabase.oneDao()
    }

}