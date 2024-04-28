package com.komparo.helpfullinks.data.mappers

import com.komparo.helpfullinks.data.model.One
import com.komparo.helpfullinks.domain.models.OneD

class OneMapper : Mapper<One, OneD> {
    override fun mapFromEntity(type: One): OneD {
        return OneD(
            title = type.title,
            image = type.image)
    }

    override fun mapToEntity(type: OneD): One {
        return One(
            title = type.title,
            image = type.image)
    }
}