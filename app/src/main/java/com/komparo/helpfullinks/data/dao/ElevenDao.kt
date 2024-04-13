package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Eleven

@Dao
interface ElevenDao {
    @Query("SELECT * FROM eleven")
    fun getAll(): List<Eleven>

    @Query("DELETE FROM eleven")
    fun deleteAll()

    @Insert
    fun insertEleven(eleven: Eleven)

    @Delete
    fun deleteEleven(eleven: Eleven)

    @Update
    fun updateOne(eleven: Eleven)
}