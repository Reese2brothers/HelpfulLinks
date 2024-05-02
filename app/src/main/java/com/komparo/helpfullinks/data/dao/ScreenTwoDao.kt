package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenTwo

@Dao
interface ScreenTwoDao {

    @Query("SELECT * FROM ScreenTwo")
    suspend fun getAllLinks(): List<ScreenTwo>

    @Query("DELETE FROM ScreenTwo")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenTwo(screenTwo : ScreenTwo)

    @Delete
    suspend fun deleteScreenTwo(screenTwo : ScreenTwo)

}