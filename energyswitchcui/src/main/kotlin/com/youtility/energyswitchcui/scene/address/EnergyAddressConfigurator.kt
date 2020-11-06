package com.youtility.energyswitchcui.scene.address

import com.youtility.energyswitchcui.common.base.Configurator

class EnergyAddressConfigurator : Configurator<EnergyAddressActivity> {

    override fun configure(view: EnergyAddressActivity) {
        val presenter: EnergyAddressContract.Presenter = EnergyAddressPresenter(view)
        val interactor = EnergyAddressInteractor(presenter, EnergySupplierRepositoryImpl())
        val router: EnergyAddressContract.Router = EnergyAddressRouter(view)
        view.router = router
        view.interactor = interactor
    }

}

