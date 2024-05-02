package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenEight

@Dao
interface ScreenEightDao {

    @Query("SELECT * FROM ScreenEight")
    suspend fun getAllLinks(): List<ScreenEight>

    @Query("DELETE FROM ScreenEight")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenEight(screenEight : ScreenEight)

    @Delete
    suspend fun deleteScreenEight(screenEight : ScreenEight)

}