package com.youtility.energyswitchcui.scene.postcode

import io.reactivex.Observable

interface PostcodeRepository {
    fun validatePostcode(postcode: String): Observable<Any>
}