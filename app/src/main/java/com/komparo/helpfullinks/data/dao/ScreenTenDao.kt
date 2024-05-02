package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenTen

@Dao
interface ScreenTenDao {

    @Query("SELECT * FROM ScreenTen")
    suspend fun getAllLinks(): List<ScreenTen>

    @Query("DELETE FROM ScreenTen")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenTen(screenTen : ScreenTen)

    @Delete
    suspend fun deleteScreenTen(screenTen : ScreenTen)

}