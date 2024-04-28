package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Eleven
import com.komparo.helpfullinks.data.model.Two

@Dao
interface ElevenDao {
    @Query("SELECT * FROM Eleven")
    fun getTitle(): Eleven?

    @Query("SELECT * FROM Eleven ")
    fun getImage(): Eleven?

    @Query("DELETE FROM eleven")
    fun deleteAll()

    @Insert
    fun insertEleven(eleven: Eleven)

}