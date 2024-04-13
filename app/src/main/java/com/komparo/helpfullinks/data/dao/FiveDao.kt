package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Five

@Dao
interface FiveDao {
    @Query("SELECT * FROM five")
    fun getAll(): List<Five>

    @Query("DELETE FROM five")
    fun deleteAll()

    @Insert
    fun insertFive(five : Five)

    @Delete
    fun deleteFive(five : Five)

    @Update
    fun updateFive(five : Five)
}