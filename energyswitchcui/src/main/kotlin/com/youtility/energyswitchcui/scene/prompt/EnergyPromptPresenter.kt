package com.youtility.energyswitchcui.scene.prompt

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class EnergyPromptPresenter(private val view: EnergyPromptContract.View) : EnergyPromptContract.Presenter {

    override fun presentLoginSuccess() {
        view.onLoginSuccess()
    }

    override fun presentLoginError(errorMessage: String) {
        view.showError(errorMessage)
    }
}