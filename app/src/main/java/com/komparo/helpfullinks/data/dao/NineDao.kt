package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Nine
import com.komparo.helpfullinks.data.model.Two

@Dao
interface NineDao {
    @Query("SELECT * FROM Nine")
    fun getTitle(): Nine?

    @Query("SELECT * FROM Nine ")
    fun getImage(): Nine?

    @Query("DELETE FROM nine")
    fun deleteAll()

    @Insert
    fun insertNine(nine : Nine)

}