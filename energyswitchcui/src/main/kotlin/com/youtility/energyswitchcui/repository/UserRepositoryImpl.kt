package com.youtility.energyswitchcui.repository


import com.youtility.energyswitchcui.common.datastore.user.AuthService
import com.youtility.energyswitchcui.common.datastore.user.UserCache
import com.youtility.energyswitchcui.mapper.AuthResponseTokenMapper
import com.youtility.energyswitchcui.model.AuthToken
import com.youtility.energyswitchcui.repository.base.UserRepository
import io.reactivex.Observable

/**
 * Created by Mohit Rajput on 2/4/19.
 * Current users profile data provider
 */
class UserRepositoryImpl(private val authService: AuthService, private val userCache: UserCache) : UserRepository {
    override fun saveAuthDetails(authToken: AuthToken) {
        userCache.saveAuthDetails(authToken)
    }

    override fun getAuthDetails(mobileNumber: String, passcode: String, clientId: String, grantType: String, scope: String): Observable<AuthToken> {
        val authResponseTokenMapper = AuthResponseTokenMapper()
        val authResponse = authService.login(mobileNumber, passcode, clientId, grantType, scope)
        return authResponse.flatMap { authResponseData ->
            Observable.just(authResponseTokenMapper.mapFrom(authResponseData))
        }
    }
}