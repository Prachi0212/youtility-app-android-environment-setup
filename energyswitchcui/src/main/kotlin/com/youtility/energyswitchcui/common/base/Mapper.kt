package com.youtility.energyswitchcui.common.base

/**
 * Created by Mohit Rajput on 2/4/19.
 * Maps one entity of one layer to another entity of different layer
 */
interface Mapper<E, T> {
    fun mapFrom(from: E): T
}
