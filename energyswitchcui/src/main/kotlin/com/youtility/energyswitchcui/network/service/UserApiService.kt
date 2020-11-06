package com.youtility.energyswitchcui.network.service

import com.youtility.energyswitchcui.network.response.AuthResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * Created by Mohit Rajput on 2/4/19.
 * Retrofit API interface for users related APIs
 */
interface UserApiService {
    companion object {
        private const val LOGIN: String = "/auth/connect/token"
    }

    @FormUrlEncoded
    @POST
    fun login(@Url url:String, @Field("username") mobileNumber: String, @Field("password") passcode: String, @Field("client_id") clientType: String, @Field("grant_type") grantType: String, @Field("scope") scope: String): Observable<AuthResponse>
}