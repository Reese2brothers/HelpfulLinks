package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Twelve

@Dao
interface TwelveDao {
    @Query("SELECT * FROM twelve")
    fun getAll(): List<Twelve>

    @Query("DELETE FROM twelve")
    fun deleteAll()

    @Insert
    fun insertTwelve(twelve : Twelve)

    @Delete
    fun deleteTwelve(twelve : Twelve)

    @Update
    fun updateTwelve(twelve : Twelve)
}