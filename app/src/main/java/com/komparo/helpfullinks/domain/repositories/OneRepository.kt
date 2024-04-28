package com.komparo.helpfullinks.domain.repositories

import com.komparo.helpfullinks.domain.models.OneD
import javax.inject.Inject

interface OneRepository {
    suspend fun getTitle(id : Int): OneD?
    suspend fun deleteAll()
    suspend fun insertOne(oneD : OneD)
    suspend fun deleteOne(oneD : OneD)
}