package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenFourteen

@Dao
interface ScreenFourteenDao {

    @Query("SELECT * FROM ScreenFourteen")
    suspend fun getAllLinks(): List<ScreenFourteen>

    @Query("DELETE FROM ScreenFourteen")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenFourteen(screenFourteen : ScreenFourteen)

    @Delete
    suspend fun deleteScreenFourteen(screenFourteen : ScreenFourteen)

}