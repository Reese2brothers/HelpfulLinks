package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.One

@Dao
interface OneDao {
    @Query("SELECT * FROM One")
     fun getTitle(): One?

    @Query("SELECT * FROM One ")
     fun getImage(): One?

    @Query("DELETE FROM one")
     fun deleteAll()

    @Insert
      fun insertOne(one : One)

}