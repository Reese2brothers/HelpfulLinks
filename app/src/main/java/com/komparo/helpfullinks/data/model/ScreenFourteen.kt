package com.komparo.helpfullinks.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ScreenFourteen(
    val linktext: String,
    val linkimage: String,
    val url: String,
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

