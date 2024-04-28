package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Five
import com.komparo.helpfullinks.data.model.Two

@Dao
interface FiveDao {
    @Query("SELECT * FROM Five")
    fun getTitle(): Five?

    @Query("SELECT * FROM Five")
    fun getImage(): Five?

    @Query("DELETE FROM five")
    fun deleteAll()

    @Insert
    fun insertFive(five : Five)

}