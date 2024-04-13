package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Fifteen

@Dao
interface FifteenDao {
    @Query("SELECT * FROM fifteen")
    fun getAll(): List<Fifteen>

    @Query("DELETE FROM fifteen")
    fun deleteAll()

    @Insert
    fun insertFifteen(fifteen : Fifteen)

    @Delete
    fun deleteFifteen(fifteen : Fifteen)

    @Update
    fun updateFifteen(fifteen : Fifteen)
}