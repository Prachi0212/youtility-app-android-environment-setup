package com.youtility.scene.splash;

import com.youtility.common.base.Configurator;
import com.youtility.common.datastore.user.LocalUserDataStore;
import com.youtility.repository.UserRepositoryImpl;
import com.youtility.scene.splash.base.SplashPresenter;
import com.youtility.scene.splash.base.SplashRouter;
import com.youtility.utils.SharedPreferenceUtils;

/**
 * Created by Mohit Rajput on 20/3/19.
 * Configure each layer of VIPER for splash screen
 */
public class SplashConfigurator implements Configurator<SplashActivity> {

    @Override
    public void configure(SplashActivity view) {
        LocalUserDataStore localUserDataStore = new LocalUserDataStore(SharedPreferenceUtils.getInstance(view));
        SplashInteractor interactor = new SplashInteractor(new UserRepositoryImpl(localUserDataStore));
        SplashPresenter presenter = new SplashPresenterImpl();
        ((SplashPresenterImpl) presenter).setView(view);
        view.setInteractor(interactor);
        interactor.setPresenter(presenter);
        SplashRouter router = new SplashRouterImpl(view);
        view.setRouter(router);
    }
}
