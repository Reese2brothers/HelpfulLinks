package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenNine

@Dao
interface ScreenNineDao {

    @Query("SELECT * FROM ScreenNine")
    suspend fun getAllLinks(): List<ScreenNine>

    @Query("DELETE FROM ScreenNine")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenNine(screenNine : ScreenNine)

    @Delete
    suspend fun deleteScreenNine(screenNine : ScreenNine)

}