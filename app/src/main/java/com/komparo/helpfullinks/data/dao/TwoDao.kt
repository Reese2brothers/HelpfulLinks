package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Two

@Dao
interface TwoDao {
    @Query("SELECT * FROM two")
    fun getAll(): List<Two>

    @Query("DELETE FROM two")
    fun deleteAll()

    @Insert
    fun insertTwo(two : Two)

    @Delete
    fun deleteTwo(two : Two)

    @Update
    fun updateTwo(two : Two)
}