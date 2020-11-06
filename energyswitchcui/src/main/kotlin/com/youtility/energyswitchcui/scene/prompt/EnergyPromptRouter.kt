package com.youtility.energyswitchcui.scene.prompt

import android.content.Intent
import com.youtility.energyswitchcui.scene.postcode.EnterPostcodeActivity

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class EnergyPromptRouter(private val activity: EnergyPromptActivity) : EnergyPromptContract.Router {
    override fun goToPostcodeScreen() {
        val intent = Intent(activity, EnterPostcodeActivity::class.java)
        activity.startActivity(intent)
    }
}