package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Fifteen
import com.komparo.helpfullinks.data.model.Two

@Dao
interface FifteenDao {
    @Query("SELECT * FROM Fifteen")
    fun getTitle(): Fifteen?

    @Query("SELECT * FROM Fifteen ")
    fun getImage(): Fifteen?

    @Query("DELETE FROM fifteen")
    fun deleteAll()

    @Insert
    fun insertFifteen(fifteen : Fifteen)

}