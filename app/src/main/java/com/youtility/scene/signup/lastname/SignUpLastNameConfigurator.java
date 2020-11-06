package com.youtility.scene.signup.lastname;

import com.youtility.common.base.Configurator;
import com.youtility.common.datastore.user.LocalUserDataStore;
import com.youtility.repository.UserRepositoryImpl;
import com.youtility.scene.signup.lastname.base.SignUpLastNamePresenter;
import com.youtility.scene.signup.lastname.base.SignUpLastNameRouter;
import com.youtility.utils.SharedPreferenceUtils;

public class SignUpLastNameConfigurator implements Configurator<SignUpLastNameActivity> {

    @Override
    public void configure(SignUpLastNameActivity view) {
        LocalUserDataStore localUserDataStore = new LocalUserDataStore(SharedPreferenceUtils.getInstance(view));
        SignUpLastNameInteractor interactor = new SignUpLastNameInteractor(new UserRepositoryImpl(localUserDataStore));
        SignUpLastNamePresenter presenter = new SignUpLastNamePresenterImpl();
        ((SignUpLastNamePresenterImpl) presenter).setView(view);
        interactor.setPresenter(presenter);
        view.setInteractor(interactor);
        SignUpLastNameRouter router = new SingUpLastNameRouterImpl(view);
        view.setRouter(router);
    }
}
