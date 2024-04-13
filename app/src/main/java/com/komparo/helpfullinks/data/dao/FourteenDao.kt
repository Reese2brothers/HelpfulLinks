package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Fourteen

@Dao
interface FourteenDao {
    @Query("SELECT * FROM fourteen")
    fun getAll(): List<Fourteen>

    @Query("DELETE FROM fourteen")
    fun deleteAll()

    @Insert
    fun insertFourteen(fourteen : Fourteen)

    @Delete
    fun deleteFourteen(fourteen : Fourteen)

    @Update
    fun updateFourteen(fourteen : Fourteen)
}