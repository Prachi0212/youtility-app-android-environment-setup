package com.youtility.energyswitchcui.network

import com.youtility.energyswitchcui.common.Constants
import com.youtility.energyswitchcui.utils.EnergySharedPreference
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by Mohit Rajput on 3/4/19.
 * Interceptor to add headers azure function calls
 */

class ApiInterceptor : Interceptor {
    private val HEADER_AUTHORIZATION = "Authorization"
    private fun prepareInterceptorRequest(chain: Interceptor.Chain): Request {
        val builder = chain.request().newBuilder()
        val token = getToken()
        if (!token.isBlank()) {
            builder.addHeader(HEADER_AUTHORIZATION, token)
        }
        return builder.build()
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = prepareInterceptorRequest(chain)
        return chain.proceed(request)
    }

    private fun getToken(): String {
        val token = EnergySharedPreference.getString(Constants.PreferenceKeys.BEARER_TOKEN)
        return token.orEmpty()
    }
}
