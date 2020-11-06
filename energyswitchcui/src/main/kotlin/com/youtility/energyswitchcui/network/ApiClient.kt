package com.youtility.energyswitchcui.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.youtility.energyswitchcui.BuildConfig
import com.youtility.energyswitchcui.common.Constants
import com.youtility.energyswitchcui.network.service.EnergyApiService
import com.youtility.energyswitchcui.network.service.UserApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mohit Rajput on 3/4/19.
 * Provides API interface of retrofit
 */

object ApiClient {
    private val TIMEOUT_IN_SECONDS = 120
    private val retrofit = createRetrofitInstance()
    internal val userApiService: UserApiService = retrofit.create(UserApiService::class.java)
    internal val energyApiService: EnergyApiService = retrofit.create(EnergyApiService::class.java)

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
                .addInterceptor(ApiInterceptor())

        if (!(BuildConfig.FLAVOR.equals(Constants.General.PROD, ignoreCase = true) && !BuildConfig.DEBUG)) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }
        return builder.build()
    }

    private fun createRetrofitInstance(): Retrofit {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        return Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}
