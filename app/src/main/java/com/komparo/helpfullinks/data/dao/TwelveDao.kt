package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Twelve
import com.komparo.helpfullinks.data.model.Two

@Dao
interface TwelveDao {
    @Query("SELECT * FROM Twelve")
    fun getTitle(): Twelve?

    @Query("SELECT * FROM Twelve ")
    fun getImage(): Twelve?

    @Query("DELETE FROM twelve")
    fun deleteAll()

    @Insert
    fun insertTwelve(twelve : Twelve)

}