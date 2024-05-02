package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenFifteen

@Dao
interface ScreenFifteenDao {

    @Query("SELECT * FROM ScreenFifteen")
    suspend fun getAllLinks(): List<ScreenFifteen>

    @Query("DELETE FROM ScreenFifteen")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenFifteen(screenFifteen : ScreenFifteen)

    @Delete
    suspend fun deleteScreenFifteen(screenFifteen : ScreenFifteen)

}