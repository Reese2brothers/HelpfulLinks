package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenSeven

@Dao
interface ScreenSevenDao {

    @Query("SELECT * FROM ScreenSeven")
    suspend fun getAllLinks(): List<ScreenSeven>

    @Query("DELETE FROM ScreenSeven")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenSeven(screenSeven : ScreenSeven)

    @Delete
    suspend fun deleteScreenSeven(screenSeven : ScreenSeven)

}