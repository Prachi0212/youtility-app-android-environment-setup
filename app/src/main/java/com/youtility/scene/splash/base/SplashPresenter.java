package com.youtility.scene.splash.base;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public interface SplashPresenter {
    void presentUserSessionDetails(Observable<Boolean> isLoggedInObservable);
}
