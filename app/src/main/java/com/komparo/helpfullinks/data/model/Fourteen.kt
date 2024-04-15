package com.komparo.helpfullinks.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fourteen(
    val title: String,
    val image: String,
    val linktext : String,
    val linkimage : String
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
