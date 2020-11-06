package com.youtility.energyswitchcui.scene.postcode

import com.youtility.energyswitchcui.common.base.BaseView

/**
 * Created by Gajanand Chouhan on 2/4/19.
 */
class EnterPostcodeContract {
    interface View : BaseView {
        fun displayInstructionAndDescription(instruction: String, description: String)
        fun displayPostcode(postcode: String);
        fun displayInvalidPostcodeError(message: String)
        fun onPostcodeValidationSuccess()
    }

    interface Router {
        fun goToAddressList()
    }

    interface Presenter {
        fun presentInstructionAndDescription(instruction: String, description: String)
        fun presentPostcode(postcode: String)
        fun presentPostcodeValidationResult(message: String, isValidated: Boolean)
    }

    interface Interactor {
        fun validatePostcode(postcode: String)
    }
}