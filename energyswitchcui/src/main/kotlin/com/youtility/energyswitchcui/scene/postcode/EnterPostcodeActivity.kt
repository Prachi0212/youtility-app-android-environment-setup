package com.youtility.energyswitchcui.scene.postcode

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.youtility.energyswitchcui.R
import com.youtility.energyswitchcui.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_enter_postcode.*
import kotlinx.android.synthetic.main.toolbar_enery_flow.*

class EnterPostcodeActivity : BaseActivity(), EnterPostcodeContract.View, View.OnClickListener {

    internal lateinit var router: EnterPostcodeContract.Router
    internal lateinit var interactor: EnterPostcodeInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_postcode)
        setup();
    }

    private fun setup() {
        btnBack.setOnClickListener(this)
        etPostcode.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnContinue.isEnabled = s.isNullOrEmpty().not()
            }

        })
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnContinue -> {
                interactor.validatePostcode(etPostcode.text.toString().trim())
            }

            R.id.btnBack -> {
                onBackPressed()
            }
        }

    }

    override fun displayPostcode(postcode: String) {
        etPostcode.setText(postcode)
    }

    override fun displayInvalidPostcodeError(message: String) {
        tvLablePostcode.setTextColor(getColor(R.color.pink))
        tvErrorMessage.visibility = View.VISIBLE
        tvErrorMessage.setText(message)
        view.setBackgroundColor(getColor(R.color.pink))
    }

    override fun displayInstructionAndDescription(instruction: String, description: String) {
        tvInstruction.setText(instruction)
        tvDescription.setText(description)
    }

    override fun onPostcodeValidationSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}