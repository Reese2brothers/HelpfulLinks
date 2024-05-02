package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.komparo.helpfullinks.data.model.ScreenThree

@Dao
interface ScreenThreeDao {

    @Query("SELECT * FROM ScreenThree")
    suspend fun getAllLinks(): List<ScreenThree>

    @Query("DELETE FROM ScreenThree")
    suspend fun deleteAll()

    @Insert
    suspend fun insertScreenThree(screenThree : ScreenThree)

    @Delete
    suspend fun deleteScreenThree(screenThree : ScreenThree)

}