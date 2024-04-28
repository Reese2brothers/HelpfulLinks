package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Six
import com.komparo.helpfullinks.data.model.Two

@Dao
interface SixDao {
    @Query("SELECT * FROM Six")
    fun getTitle(): Six?

    @Query("SELECT * FROM Six ")
    fun getImage(): Six?

    @Query("DELETE FROM six")
    fun deleteAll()

    @Insert
    fun insertSix(six : Six)

}