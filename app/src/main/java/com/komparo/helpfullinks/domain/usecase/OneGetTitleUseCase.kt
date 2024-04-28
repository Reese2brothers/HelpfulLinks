package com.komparo.helpfullinks.domain.usecase

import com.komparo.helpfullinks.domain.models.OneD
import com.komparo.helpfullinks.domain.repositories.OneRepository

class OneGetTitleUseCase(private val oneRepository : OneRepository) {
     suspend fun execute(id : Int) : OneD? {
        return oneRepository.getTitle(id = id)
    }
}