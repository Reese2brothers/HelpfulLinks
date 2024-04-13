package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Ten

@Dao
interface TenDao {
    @Query("SELECT * FROM ten")
    fun getAll(): List<Ten>

    @Query("DELETE FROM ten")
    fun deleteAll()

    @Insert
    fun insertTen(ten : Ten)

    @Delete
    fun deleteTen(ten : Ten)

    @Update
    fun updateTen(ten : Ten)
}