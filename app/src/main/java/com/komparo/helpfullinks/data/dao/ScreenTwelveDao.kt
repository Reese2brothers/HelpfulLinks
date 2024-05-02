package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenTwelve

@Dao
interface ScreenTwelveDao {

    @Query("SELECT * FROM ScreenTwelve")
    suspend fun getAllLinks(): List<ScreenTwelve>

    @Query("DELETE FROM ScreenTwelve")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenTwelve(screenTwelve : ScreenTwelve)

    @Delete
    suspend fun deleteScreenTwelve(screenTwelve : ScreenTwelve)

}