package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Six

@Dao
interface SixDao {
    @Query("SELECT * FROM six")
    fun getAll(): List<Six>

    @Query("DELETE FROM six")
    fun deleteAll()

    @Insert
    fun insertSix(six : Six)

    @Delete
    fun deleteSix(six : Six)

    @Update
    fun updateSix(six : Six)
}