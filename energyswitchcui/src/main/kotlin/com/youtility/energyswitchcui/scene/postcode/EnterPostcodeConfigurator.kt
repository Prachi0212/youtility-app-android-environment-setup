package com.youtility.energyswitchcui.scene.postcode

import com.youtility.energyswitchcui.common.base.Configurator

/**
 * Created by Gajanand Chouhan on 2/4/19.
 */
class EnterPostcodeConfigurator : Configurator<EnterPostcodeActivity> {

    override fun configure(view: EnterPostcodeActivity) {
        val router: EnterPostcodeContract.Router = EnterPostcodeRouter(view)
        view.router = router
        val presenter: EnterPostcodeContract.Presenter = EnterPostcodePresenter(view)
        val interactor = EnterPostcodeInteractor(presenter, PostcodeRepositoryImpl())
        view.interactor = interactor
    }
}