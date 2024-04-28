package com.komparo.helpfullinks.domain.usecase

import com.komparo.helpfullinks.domain.repositories.OneRepository

class OneDeleteAllUseCase(private val oneRepository : OneRepository) {
       suspend fun execute(){
            return oneRepository.deleteAll()
        }
}