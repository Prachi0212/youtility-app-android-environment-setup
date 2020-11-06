package com.youtility.energyswitchcui.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Mohit Rajput on 9/4/19.
 */
data class GetPostcodeStepResponse(
        @SerializedName("instruction")
        val instruction: String
)