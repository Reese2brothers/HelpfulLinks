package com.komparo.helpfullinks.domain.usecase

import com.komparo.helpfullinks.domain.models.OneD
import com.komparo.helpfullinks.domain.repositories.OneRepository

class OneInsertUseCase(private val oneRepository : OneRepository) {
     suspend fun execute(oneD : OneD){
        return oneRepository.insertOne(oneD)
    }
}