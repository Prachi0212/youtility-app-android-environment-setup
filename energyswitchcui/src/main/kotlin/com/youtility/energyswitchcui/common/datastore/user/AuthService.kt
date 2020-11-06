package com.youtility.energyswitchcui.common.datastore.user

import com.youtility.energyswitchcui.network.response.AuthResponse
import io.reactivex.Observable

/**
 * Created by Mohit Rajput on 2/4/19.
 */
interface AuthService {
    fun login(mobileNumber: String, passcode: String, clientId: String, grantType: String, scope: String): Observable<AuthResponse>
}
