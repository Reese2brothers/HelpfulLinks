package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Nine

@Dao
interface NineDao {
    @Query("SELECT * FROM nine")
    fun getAll(): List<Nine>

    @Query("DELETE FROM nine")
    fun deleteAll()

    @Insert
    fun insertNine(nine : Nine)

    @Delete
    fun deleteNine(nine : Nine)

    @Update
    fun updateNine(nine : Nine)
}