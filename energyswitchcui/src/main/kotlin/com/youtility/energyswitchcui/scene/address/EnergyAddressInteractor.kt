package com.youtility.energyswitchcui.scene.address


class EnergyAddressInteractor(private val presenter: EnergyAddressContract.Presenter, private val repository: EnergySupplierRepository) : EnergyAddressContract.Interactor {

    override fun getEnergySupplierList(submitValue: String) {
        presenter.presentEnergySupplierListResult(submitValue)
    }

}

