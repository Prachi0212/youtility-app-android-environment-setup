package com.youtility.energyswitchcui.common.base

/**
 * Created by Mohit Rajput on 2/4/19.
 * Parent configurator of VIPER layers
 */
interface Configurator<T : BaseView> {
    fun configure(view: T)
}
