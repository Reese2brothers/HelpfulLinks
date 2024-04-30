package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenOne

@Dao
interface ScreenOneDao {

    @Query("SELECT * FROM ScreenOne")
    suspend fun getAllLinks(): List<ScreenOne>

    @Query("DELETE FROM ScreenOne")
    fun deleteAll()

    @Insert
    fun insertScreenOne(screenOne : ScreenOne)

    @Delete
    fun deleteScreenOne(screenOne : ScreenOne)
}