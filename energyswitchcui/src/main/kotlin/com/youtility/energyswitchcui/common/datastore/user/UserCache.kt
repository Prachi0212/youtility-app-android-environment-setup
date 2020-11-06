package com.youtility.energyswitchcui.common.datastore.user

import com.youtility.energyswitchcui.model.AuthToken

/**
 * Created by Mohit Rajput on 4/4/19.
 */
interface UserCache {
    fun saveAuthDetails(authToken: AuthToken)
}
