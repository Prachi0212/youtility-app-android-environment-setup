package com.youtility.energyswitchcui.scene.prompt

import com.youtility.energyswitchcui.common.Constants
import com.youtility.energyswitchcui.common.DisposableCollector
import com.youtility.energyswitchcui.repository.base.UserRepository
import com.youtility.energyswitchcui.utils.EncryptionUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mohit Rajput on 2/4/19.
 */
class EnergyPromptInteractor(private val presenter: EnergyPromptContract.Presenter, private val repository: UserRepository) : EnergyPromptContract.Interactor {
    private val disposableCollector = DisposableCollector()

    override fun login(mobileNumber: String, passcode: String) {
        val hashedPassword = EncryptionUtils.getSHA256(passcode);
        val grantType = "password"
        val scope = "email openid profile offline_access youtility.api.app"

        val authTokenObservable = repository.getAuthDetails(mobileNumber, hashedPassword, Constants.General.CLIENT_ID, grantType, scope)

        disposableCollector.addDisposable(authTokenObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> run { repository.saveAuthDetails(result); presenter.presentLoginSuccess() } },
                        { throwable -> throwable.message?.let { presenter.presentLoginError(it) } }))
    }

    override fun clear() {
        disposableCollector.clearDisposables()
    }
}