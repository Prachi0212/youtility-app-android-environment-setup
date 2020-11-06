package com.youtility.energyswitchcui.mapper

import com.youtility.energyswitchcui.common.Constants
import com.youtility.energyswitchcui.common.base.Mapper
import com.youtility.energyswitchcui.model.AuthToken
import com.youtility.energyswitchcui.network.response.AuthResponse

/**
 * Created by Mohit Rajput on 8/4/19.
 */
class AuthResponseTokenMapper : Mapper<AuthResponse, AuthToken> {
    override fun mapFrom(from: AuthResponse): AuthToken {
        return AuthToken(
                bearerToken = from.tokenType + Constants.General.SPACE + from.accessToken,
                expiresIn = from.expiresIn,
                refreshToken = from.refreshToken
        )
    }
}
