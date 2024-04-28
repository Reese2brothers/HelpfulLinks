package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Ten
import com.komparo.helpfullinks.data.model.Two

@Dao
interface TenDao {
    @Query("SELECT * FROM Ten")
    fun getTitle(): Ten?

    @Query("SELECT * FROM Ten ")
    fun getImage(): Ten?

    @Query("DELETE FROM ten")
    fun deleteAll()

    @Insert
    fun insertTen(ten : Ten)

}