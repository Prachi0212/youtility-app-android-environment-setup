package com.youtility.energyswitchcui.common

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class Constants {
    interface IntentExtras {

    }

    interface PreferenceKeys {
        companion object {
            val BEARER_TOKEN = "bearer_token"
            val EXPIRES_IN = "expires_in"
            val REFRESH_TOKEN = "refresh_token"
        }
    }

    interface General {
        companion object {
            val EMPTY = ""
            val SPACE = " "
            val PROD = "prod"
            val CLIENT_ID = "youtility.ios.app"
        }
    }

    interface Url {

    }
}
