package com.youtility.energyswitchcui.scene.address


import com.youtility.energyswitchcui.common.base.BaseView
import com.youtility.energyswitchcui.model.Address
import com.youtility.energyswitchcui.model.Supplier


class EnergyAddressContract {

    interface View : BaseView {
        fun onEnergySupplierListSuccess(arrayList:ArrayList<Supplier>)
        fun showAddressList(addresses:ArrayList<Address>,instruction:String)
    }

    interface Router {
        fun goToSelectEnergySupplierScreen()
    }

    interface Presenter {
        fun presentEnergySupplierListResult(submitValue: String);
        fun presentAddressList(addresses:ArrayList<Address>, instruction:String);
    }

    interface Interactor {
        fun getEnergySupplierList(submitValue: String);
    }
}