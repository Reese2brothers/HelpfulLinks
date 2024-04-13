package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.One

@Dao
interface OneDao {
    @Query("SELECT * FROM one")
    suspend fun getAll(): List<One>

    @Query("DELETE FROM one")
    suspend fun deleteAll()

    @Insert
    suspend fun insertOne(one : One)

    @Delete
    suspend fun deleteOne(one : One)

    @Update
    suspend fun updateOne(one : One)
}