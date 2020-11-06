package com.youtility.scene.splash;

import com.youtility.YoutilityApplication;
import com.youtility.repository.base.UserRepository;
import com.youtility.scene.splash.base.SplashPresenter;

import io.reactivex.Observable;
import lombok.Setter;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public class SplashInteractor {
    private UserRepository repository;
    @Setter
    private SplashPresenter presenter;

    public SplashInteractor(UserRepository repository) {
        this.repository = repository;
    }

    public void loadUserSessionDetails() {
        Observable<Boolean> optionalObservable = repository.isUserLoggedIn();
        presenter.presentUserSessionDetails(optionalObservable);
    }
}
