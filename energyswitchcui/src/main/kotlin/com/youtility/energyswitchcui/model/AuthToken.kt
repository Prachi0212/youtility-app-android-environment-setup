package com.youtility.energyswitchcui.model

/**
 * Created by Mohit Rajput on 8/4/19.
 * Contains authentication token and its related information i.e. expiry time
 */
data class AuthToken(
        val bearerToken: String,
        val expiresIn: Int,
        val refreshToken: String
)
