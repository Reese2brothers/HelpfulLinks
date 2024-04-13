package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Three

@Dao
interface ThreeDao {
    @Query("SELECT * FROM three")
    fun getAll(): List<Three>

    @Query("DELETE FROM three")
    fun deleteAll()

    @Insert
    fun insertThree(three : Three)

    @Delete
    fun deleteThree(three : Three)

    @Update
    fun updateThree(three : Three)
}