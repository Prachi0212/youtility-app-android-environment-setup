package com.youtility.energyswitchcui.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Mohit Rajput on 4/4/19.
 */
data class AuthResponse(
        @SerializedName("access_token")
        val accessToken: String,

        @SerializedName("expires_in")
        val expiresIn: Int,

        @SerializedName("token_type")
        val tokenType: String,

        @SerializedName("refresh_token")
        val refreshToken: String
)
