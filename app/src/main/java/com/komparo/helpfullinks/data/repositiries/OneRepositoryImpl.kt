package com.komparo.helpfullinks.data.repositiries

import com.komparo.helpfullinks.data.dao.OneDao
import com.komparo.helpfullinks.data.mappers.OneMapper
import com.komparo.helpfullinks.domain.models.OneD
import com.komparo.helpfullinks.domain.repositories.OneRepository
import javax.inject.Inject

//class OneRepositoryImpl @Inject constructor(private val oneDao : OneDao) : OneRepository{
//    override suspend fun getTitle(id: Int): OneD? {
//       return oneDao.getTitle()?.let{OneMapper().mapFromEntity(it)}
//    }
//
//    override suspend fun deleteAll() {
//       oneDao.deleteAll()
//    }
//
//    override suspend fun insertOne(oneD: OneD) {
//        oneDao.insertOne(one = OneMapper().mapToEntity(oneD))
//    }
//
//    override suspend fun deleteOne(oneD: OneD) {
//        oneDao.deleteOne(one = OneMapper().mapToEntity(oneD))
//    }
//}