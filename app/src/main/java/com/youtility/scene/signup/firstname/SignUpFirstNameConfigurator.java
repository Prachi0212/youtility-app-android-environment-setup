package com.youtility.scene.signup.firstname;

import com.youtility.common.base.Configurator;
import com.youtility.common.datastore.user.LocalUserDataStore;
import com.youtility.repository.UserRepositoryImpl;
import com.youtility.scene.signup.firstname.base.SignUpFirstNamePresenter;
import com.youtility.scene.signup.firstname.base.SignUpFirstNameRouter;
import com.youtility.utils.SharedPreferenceUtils;

public class SignUpFirstNameConfigurator implements Configurator<SignUpFirstNameActivity> {

    @Override
    public void configure(SignUpFirstNameActivity view) {
        LocalUserDataStore localUserDataStore = new LocalUserDataStore(SharedPreferenceUtils.getInstance(view));
        SignUpFirstNameInteractor interactor = new SignUpFirstNameInteractor(new UserRepositoryImpl(localUserDataStore));
        SignUpFirstNamePresenter presenter = new SignUpFirstNamePresenterImpl();
        ((SignUpFirstNamePresenterImpl) presenter).setView(view);
        interactor.setPresenter(presenter);
        view.setInteractor(interactor);
        SignUpFirstNameRouter router = new SingUpFirstNameRouterImpl(view);
        view.setRouter(router);
    }
}
