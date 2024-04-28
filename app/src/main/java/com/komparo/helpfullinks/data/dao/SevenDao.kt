package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Seven
import com.komparo.helpfullinks.data.model.Two

@Dao
interface SevenDao {
    @Query("SELECT * FROM Seven")
    fun getTitle(): Seven?

    @Query("SELECT * FROM Seven ")
    fun getImage(): Seven?

    @Query("DELETE FROM seven")
    fun deleteAll()

    @Insert
    fun insertSeven(seven : Seven)

}