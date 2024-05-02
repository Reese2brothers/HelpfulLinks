package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenFour

@Dao
interface ScreenFourDao {

    @Query("SELECT * FROM ScreenFour")
    suspend fun getAllLinks(): List<ScreenFour>

    @Query("DELETE FROM ScreenFour")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenFour(screenFour : ScreenFour)

    @Delete
    suspend fun deleteScreenFour(screenFour : ScreenFour)

}