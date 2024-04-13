package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Seven

@Dao
interface SevenDao {
    @Query("SELECT * FROM seven")
    fun getAll(): List<Seven>

    @Query("DELETE FROM seven")
    fun deleteAll()

    @Insert
    fun insertSeven(seven : Seven)

    @Delete
    fun deleteSeven(seven : Seven)

    @Update
    fun updateSeven(seven : Seven)
}