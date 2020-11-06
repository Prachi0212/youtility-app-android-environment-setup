package com.youtility.energyswitchcui.scene.prompt

import android.os.Bundle
import com.youtility.energyswitchcui.R
import com.youtility.energyswitchcui.common.base.BaseActivity
import com.youtility.energyswitchcui.utils.NetworkUtils
import com.youtility.energyswitchcui.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_energy_prompt.*

class EnergyPromptActivity : BaseActivity(), EnergyPromptContract.View {
    internal lateinit var router: EnergyPromptContract.Router
    internal lateinit var interactor: EnergyPromptContract.Interactor
    private val dummyMobileNumber = "+917415618945"
    private val dummyPasscode = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energy_prompt)
        setup()
    }

    private fun setup() {
        EnergyPromptConfigurator().configure(this)
        if (NetworkUtils.isNetworkAvailable(context)) {
            interactor.login(dummyMobileNumber, dummyPasscode)
        } else {
            ToastUtils.showLongToast(context, R.string.network_not_available)
        }
        btnContinue.setOnClickListener { router.goToPostcodeScreen() }
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoginSuccess() {
        btnContinue.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        ToastUtils.showLongToast(context, errorMessage)
    }

    override fun onDestroy() {
        interactor.clear()
        super.onDestroy()
    }
}
