package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.One
import com.komparo.helpfullinks.data.model.Two

@Dao
interface TwoDao {
    @Query("SELECT * FROM Two")
    fun getTitle(): Two?

    @Query("SELECT * FROM Two ")
    fun getImage(): Two?

    @Query("DELETE FROM two")
    fun deleteAll()

    @Insert
    fun insertTwo(two : Two)

}