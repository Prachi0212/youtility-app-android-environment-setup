package com.youtility.energyswitchcui.scene.prompt

import com.youtility.energyswitchcui.common.base.Configurator
import com.youtility.energyswitchcui.common.datastore.user.AuthServiceImpl
import com.youtility.energyswitchcui.common.datastore.user.UserCacheImpl
import com.youtility.energyswitchcui.network.ApiClient
import com.youtility.energyswitchcui.repository.UserRepositoryImpl
import com.youtility.energyswitchcui.utils.EnergySharedPreference

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class EnergyPromptConfigurator : Configurator<EnergyPromptActivity> {
    override fun configure(view: EnergyPromptActivity) {
        EnergySharedPreference.init(view)
        val presenter: EnergyPromptContract.Presenter = EnergyPromptPresenter(view)
        val interactor = EnergyPromptInteractor(presenter, UserRepositoryImpl(AuthServiceImpl(ApiClient.userApiService), UserCacheImpl()))
        val router = EnergyPromptRouter(view)
        view.router = router
        view.interactor = interactor
    }
}