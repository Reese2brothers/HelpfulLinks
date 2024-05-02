package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenFive

@Dao
interface ScreenFiveDao {

    @Query("SELECT * FROM ScreenFive")
    suspend fun getAllLinks(): List<ScreenFive>

    @Query("DELETE FROM ScreenFive")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenFive(screenFive : ScreenFive)

    @Delete
    suspend fun deleteScreenFive(screenFive : ScreenFive)

}