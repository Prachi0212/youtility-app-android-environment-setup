package com.youtility.energyswitchcui.common.datastore.user

import com.youtility.energyswitchcui.common.Constants.PreferenceKeys.Companion.BEARER_TOKEN
import com.youtility.energyswitchcui.common.Constants.PreferenceKeys.Companion.EXPIRES_IN
import com.youtility.energyswitchcui.common.Constants.PreferenceKeys.Companion.REFRESH_TOKEN
import com.youtility.energyswitchcui.model.AuthToken
import com.youtility.energyswitchcui.utils.EnergySharedPreference

/**
 * Created by Mohit Rajput on 4/4/19.
 */
class UserCacheImpl : UserCache {
    override fun saveAuthDetails(authToken: AuthToken) {
        EnergySharedPreference.saveString(BEARER_TOKEN, authToken.bearerToken)
        EnergySharedPreference.saveInt(EXPIRES_IN, authToken.expiresIn)
        EnergySharedPreference.saveString(REFRESH_TOKEN, authToken.refreshToken)
    }
}
