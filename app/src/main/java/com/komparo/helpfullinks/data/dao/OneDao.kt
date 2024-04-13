package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.One

@Dao
interface OneDao {
    @Query("SELECT * FROM One WHERE id = :id")
     fun getTitle(id : Int): One?

    @Query("DELETE FROM one")
    fun deleteAll()

    @Insert
     fun insertOne(one : One)

    @Delete
     fun deleteOne(one : One)

    @Update
     fun updateOne(one : One)
}