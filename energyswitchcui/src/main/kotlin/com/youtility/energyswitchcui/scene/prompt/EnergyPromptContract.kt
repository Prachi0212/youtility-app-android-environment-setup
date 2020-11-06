package com.youtility.energyswitchcui.scene.prompt

import com.youtility.energyswitchcui.common.base.BaseView

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class EnergyPromptContract {
    interface View : BaseView {
        fun onLoginSuccess()
    }

    interface Router {
        fun goToPostcodeScreen()
    }

    interface Presenter {
        fun presentLoginSuccess()
        fun presentLoginError(errorMessage: String)
    }

    interface Interactor {
        fun login(mobileNumber: String, passcode: String)
        fun clear()
    }
}