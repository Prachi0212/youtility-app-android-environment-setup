package com.youtility.energyswitchcui.scene.address

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.youtility.energyswitchcui.R
import com.youtility.energyswitchcui.common.base.BaseActivity
import com.youtility.energyswitchcui.model.Address
import com.youtility.energyswitchcui.model.Supplier
import com.youtility.listnear.OnItemClickListnear
import kotlinx.android.synthetic.main.activity_select_address.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlin.collections.ArrayList


class EnergyAddressActivity : BaseActivity(), EnergyAddressContract.View, OnItemClickListnear, View.OnClickListener {


    internal lateinit var router: EnergyAddressContract.Router
    internal lateinit var interactor: EnergyAddressInteractor
    private var adapter: AddressListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_address)
        setup()
    }


    private fun setup() {
        EnergyAddressConfigurator().configure(this)
        btnBack.setOnClickListener(this)
        btnContinue.setOnClickListener(this)
        val addresses: ArrayList<Address> = populateDummyAddressList()
        val instruction: String = resources.getString(R.string.select_address)
        showAddressList(addresses,instruction)
    }


    override fun showAddressList(addresses: ArrayList<Address>, instruction: String) {
        tvHeader.text = instruction
        if(isAddressListEmpty(addresses)){
            recyclerView.visibility = View.GONE
            tvMessage.visibility = View.VISIBLE
        }else{
            recyclerView.visibility = View.VISIBLE
            tvMessage.visibility = View.GONE
            setAdapter(addresses)
        }
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnBack -> onClickBack()
            R.id.btnContinue -> onclickContinue()
        }
    }


    /**method to create dummy address list to show on adpter**/
     fun populateDummyAddressList(): ArrayList<Address>{
        val dummyAddressList = resources.getStringArray(R.array.address_list)
        val dummyAddresses = ArrayList<Address>()
        for (value in dummyAddressList) {
            val bean = Address(value.toString(), "", "", false)
            dummyAddresses.add(bean)
        }
        return dummyAddresses
    }


    /**check address list is empty or not**/

    private fun isAddressListEmpty(arrayList: ArrayList<Address>): Boolean  {
        return arrayList.size == 0
    }

    /**show address list on adapter**/

    private fun setAdapter(arrayList: ArrayList<Address>) {
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        adapter = AddressListAdapter(arrayList, applicationContext, this)
        recyclerView.adapter = adapter
    }


    /**perform action on back button of headder**/

    private fun onClickBack() {
        onBackPressed()
    }

    override fun onItemClick(possition: Int) {
        btnContinue.isEnabled = true
    }

    /**perform action on click of continue**/

    private fun onclickContinue() {
        val address = adapter!!.getSelectedAddress()
        interactor.getEnergySupplierList(address.submitValue)
    }

    /**method to get energy supplier list**/

    override fun onEnergySupplierListSuccess(arrayList: ArrayList<Supplier>) {}

    /**method to show progress bar when api call**/

    override fun showProgress() {}

    /**method to hide progress bar when api call**/

    override fun hideProgress() {}

    /**method to show error when api call**/

    override fun showError(errorMessage: String) {}
}