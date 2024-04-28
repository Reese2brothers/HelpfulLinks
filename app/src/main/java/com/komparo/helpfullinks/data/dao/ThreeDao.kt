package com.komparo.helpfullinks.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.komparo.helpfullinks.data.model.Three
import com.komparo.helpfullinks.data.model.Two

@Dao
interface ThreeDao {
    @Query("SELECT * FROM Three")
    fun getTitle(): Three?

    @Query("SELECT * FROM Three ")
    fun getImage(): Three?
    @Query("DELETE FROM three")
    fun deleteAll()

    @Insert
    fun insertThree(three : Three)

}