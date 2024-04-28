package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Thirteen
import com.komparo.helpfullinks.data.model.Two

@Dao
interface ThirteenDao {
    @Query("SELECT * FROM Thirteen")
    fun getTitle(): Thirteen?

    @Query("SELECT * FROM Thirteen ")
    fun getImage(): Thirteen?

    @Query("DELETE FROM thirteen")
    fun deleteAll()

    @Insert
    fun insertThirteen(thirteen : Thirteen)

}