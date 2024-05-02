package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenThirteen

@Dao
interface ScreenThirteenDao {

    @Query("SELECT * FROM ScreenThirteen")
    suspend fun getAllLinks(): List<ScreenThirteen>

    @Query("DELETE FROM ScreenThirteen")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenThirteen(screenThirteen : ScreenThirteen)

    @Delete
    suspend fun deleteScreenThirteen(screenThirteen : ScreenThirteen)

}