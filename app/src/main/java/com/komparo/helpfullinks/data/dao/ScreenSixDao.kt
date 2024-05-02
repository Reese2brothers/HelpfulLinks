package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenSix

@Dao
interface ScreenSixDao {

    @Query("SELECT * FROM ScreenSix")
    suspend fun getAllLinks(): List<ScreenSix>

    @Query("DELETE FROM ScreenSix")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenSix(screenSix : ScreenSix)

    @Delete
    suspend fun deleteScreenSix(screenSix : ScreenSix)

}