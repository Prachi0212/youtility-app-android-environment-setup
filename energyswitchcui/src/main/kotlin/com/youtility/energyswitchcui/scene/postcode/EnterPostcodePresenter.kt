package com.youtility.energyswitchcui.scene.postcode

/**
 * Created by Gajanand Chouhan on 2/4/19.
 */
class EnterPostcodePresenter(private val view: EnterPostcodeContract.View) : EnterPostcodeContract.Presenter {
    override fun presentPostcodeValidationResult(message: String, isValidated: Boolean) {
        if (isValidated) {
            view.onPostcodeValidationSuccess()
        } else {
            view.displayInvalidPostcodeError(message)
        }
    }

    override fun presentPostcode(postcode: String) {
        view.displayPostcode(postcode)
    }


    override fun presentInstructionAndDescription(instruction: String, description: String) {
        view.displayInstructionAndDescription(instruction, description)
    }
}