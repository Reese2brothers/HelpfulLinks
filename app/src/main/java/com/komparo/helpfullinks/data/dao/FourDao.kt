package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Four
import com.komparo.helpfullinks.data.model.Two

@Dao
interface FourDao {
    @Query("SELECT * FROM Four")
    fun getTitle(): Four?

    @Query("SELECT * FROM Four ")
    fun getImage(): Four?
    @Query("DELETE FROM four")
    fun deleteAll()

    @Insert
    fun insertFour(four : Four)

}