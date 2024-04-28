package com.komparo.helpfullinks.data.mappers

interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E
}