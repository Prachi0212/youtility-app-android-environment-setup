package com.youtility.energyswitchcui.common.base

/**
 * Created by Mohit Rajput on 2/4/19.
 * Parent view of all other views of VIPER
 */
interface BaseView {
    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)
}
