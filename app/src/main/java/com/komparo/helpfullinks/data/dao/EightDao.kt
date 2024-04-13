package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Eight

@Dao
interface EightDao {
    @Query("SELECT * FROM eight")
    fun getAll(): List<Eight>

    @Query("DELETE FROM eight")
    fun deleteAll()

    @Insert
    fun insertEight(eight : Eight)

    @Delete
    fun deleteEight(eight : Eight)

    @Update
    fun updateEight(eight : Eight)
}