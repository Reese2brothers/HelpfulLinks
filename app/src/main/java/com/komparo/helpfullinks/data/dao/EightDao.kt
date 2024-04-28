package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Eight
import com.komparo.helpfullinks.data.model.Two

@Dao
interface EightDao {
    @Query("SELECT * FROM Eight")
    fun getTitle(): Eight?

    @Query("SELECT * FROM Eight ")
    fun getImage(): Eight?

    @Query("DELETE FROM eight")
    fun deleteAll()

    @Insert
    fun insertEight(eight : Eight)

}