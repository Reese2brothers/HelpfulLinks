package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Fourteen
import com.komparo.helpfullinks.data.model.Two

@Dao
interface FourteenDao {
    @Query("SELECT * FROM Fourteen")
    fun getTitle(): Fourteen?

    @Query("SELECT * FROM Fourteen ")
    fun getImage(): Fourteen?

    @Query("DELETE FROM fourteen")
    fun deleteAll()

    @Insert
    fun insertFourteen(fourteen : Fourteen)

}