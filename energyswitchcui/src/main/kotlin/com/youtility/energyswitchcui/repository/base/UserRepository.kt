package com.youtility.energyswitchcui.repository.base

import com.youtility.energyswitchcui.model.AuthToken
import io.reactivex.Observable

/**
 * Created by Mohit Rajput on 2/4/19.
 * Current users profile data provider
 */
interface UserRepository {
    fun getAuthDetails(mobileNumber: String, passcode: String, clientId: String, grantType: String, scope: String): Observable<AuthToken>

    fun saveAuthDetails(authToken: AuthToken)
}