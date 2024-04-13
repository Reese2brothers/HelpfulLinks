package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Four

@Dao
interface FourDao {
    @Query("SELECT * FROM four")
    fun getAll(): List<Four>

    @Query("DELETE FROM four")
    fun deleteAll()

    @Insert
    fun insertFour(four : Four)

    @Delete
    fun deleteFour(four : Four)

    @Update
    fun updateFour(four : Four)
}