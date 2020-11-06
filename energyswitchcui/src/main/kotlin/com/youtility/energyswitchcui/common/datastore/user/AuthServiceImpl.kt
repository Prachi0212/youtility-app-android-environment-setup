package com.youtility.energyswitchcui.common.datastore.user

import com.youtility.energyswitchcui.BuildConfig
import com.youtility.energyswitchcui.network.response.AuthResponse
import com.youtility.energyswitchcui.network.service.UserApiService
import io.reactivex.Observable

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class AuthServiceImpl(private val userApiService: UserApiService) : AuthService {

    override fun login(mobileNumber: String, passcode: String, clientId: String, grantType: String, scope: String): Observable<AuthResponse> {
        //This URL is temporary and needs to be removed when auth APIs will be migrated to api.{env}
        val tempLoginUrl = "https://" + BuildConfig.FLAVOR + "-k8s.youtility.co.uk/auth/connect/token"
        return userApiService.login(tempLoginUrl, mobileNumber, passcode, clientId, grantType, scope)
    }
}