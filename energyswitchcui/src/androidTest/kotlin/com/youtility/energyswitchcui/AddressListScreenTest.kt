package com.youtility.energyswitchcui

import android.support.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import com.youtility.energyswitchcui.model.Address
import com.youtility.energyswitchcui.scene.address.AddressListAdapter
import com.youtility.energyswitchcui.scene.address.EnergyAddressActivity
import com.youtility.energyswitchcui.scene.address.EnergyAddressContract
import com.youtility.energyswitchcui.scene.address.EnergyAddressPresenter
import kotlinx.android.synthetic.main.activity_select_address.*
import org.junit.Rule
import org.junit.Test
import java.util.ArrayList

class AddressListScreenTest {

    @get:Rule
    val activityTestRule: ActivityTestRule<EnergyAddressActivity> = ActivityTestRule<EnergyAddressActivity>(EnergyAddressActivity::class.java, false, false)
    private var name = javaClass.simpleName

    @Test
    fun testScreenshotEntireActivity() {
        val adapter: AddressListAdapter? = null
        val activity = activityTestRule.launchActivity(null)
        val view: EnergyAddressContract.View = activity
        val presenter = EnergyAddressPresenter(view)
        val instruction: String = activity.resources.getString(R.string.select_address)



        /**
         * case 1:-  No any address result
         */
        activity.runOnUiThread {
            val addresses = ArrayList<Address>()
            presenter.presentAddressList(addresses,instruction)
        }
        Screenshot.snapActivity(activity).setName(name + "No Address Result").record()



        /**
         * case 2:- show Address list on adapter
         */
        activity.runOnUiThread {
            val addresses: ArrayList<Address> = activity.populateDummyAddressList()
            presenter.presentAddressList(addresses,instruction)
        }
        Screenshot.snapActivity(activity).setName(name + "Address Result").record()



        /**
         * case 3:- select address on list
         */
        activity.run {
            val addresses: ArrayList<Address> = activity.populateDummyAddressList()
            presenter.presentAddressList(addresses,instruction)
            adapter?.selectedPosition=2
            adapter?.notifyDataSetChanged()
            activity.btnContinue.isEnabled = true
        }
        Screenshot.snapActivity(activity).setName(name + "Checked Address").record()


    }


}
