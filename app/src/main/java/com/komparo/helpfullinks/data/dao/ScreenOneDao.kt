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
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenOne(screenOne : ScreenOne)

    @Delete
    suspend fun deleteScreenOne(screenOne : ScreenOne)

//    @Query("DELETE FROM ScreenOne WHERE id = :id")
//    fun deleteScreenOneById(id: Int)
}