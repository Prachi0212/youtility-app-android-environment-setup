package com.youtility.energyswitchcui.utils

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Request

/**
 * Created by Mohit Rajput on 11/3/19.
 */
object NetworkUtils {
    /**
     * Checks whether internet is connected in device or not
     *
     * @param context
     * @return true if connected, false otherwise
     */
    fun isNetworkAvailable(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun prepareInterceptorRequest(chain: Interceptor.Chain): Request {
        val builder = chain.request().newBuilder()
        return builder.build()
    }
}
