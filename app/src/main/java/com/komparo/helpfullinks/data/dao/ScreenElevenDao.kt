package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenEleven

@Dao
interface ScreenElevenDao {

    @Query("SELECT * FROM ScreenEleven")
    suspend fun getAllLinks(): List<ScreenEleven>

    @Query("DELETE FROM ScreenEleven")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenEleven(screenEleven : ScreenEleven)

    @Delete
    suspend fun deleteScreenEleven(screenEleven : ScreenEleven)

}