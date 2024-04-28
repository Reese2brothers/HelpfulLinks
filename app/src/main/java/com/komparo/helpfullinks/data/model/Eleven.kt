package com.komparo.helpfullinks.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Eleven(
    val title: String,
    val image: String,
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
