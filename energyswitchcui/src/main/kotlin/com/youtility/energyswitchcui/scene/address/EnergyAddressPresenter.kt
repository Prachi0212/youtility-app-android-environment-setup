package com.youtility.energyswitchcui.scene.address

import com.youtility.energyswitchcui.model.Address

class EnergyAddressPresenter(private val view: EnergyAddressContract.View) : EnergyAddressContract.Presenter {


    override fun presentEnergySupplierListResult(submitValue: String) {}

    override fun presentAddressList(addresses: ArrayList<Address>, instruction: String) {
        view.showAddressList(addresses, instruction)
    }

}