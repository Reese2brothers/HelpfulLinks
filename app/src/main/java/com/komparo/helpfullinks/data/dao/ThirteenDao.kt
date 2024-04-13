package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Thirteen

@Dao
interface ThirteenDao {
    @Query("SELECT * FROM thirteen")
    fun getAll(): List<Thirteen>

    @Query("DELETE FROM thirteen")
    fun deleteAll()

    @Insert
    fun insertThirteen(thirteen : Thirteen)

    @Delete
    fun deleteThirteen(thirteen : Thirteen)

    @Update
    fun updateThirteen(thirteen : Thirteen)
}