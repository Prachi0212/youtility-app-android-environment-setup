package com.youtility.scene.splash;

import com.youtility.common.base.Presenter;
import com.youtility.scene.splash.base.SplashPresenter;
import com.youtility.scene.splash.base.SplashView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Setter;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public class SplashPresenterImpl extends Presenter implements SplashPresenter {
    @Setter
    private SplashView view;

    @Override
    public void presentUserSessionDetails(Observable<Boolean> isLoggedInObservable) {
        addDisposable(isLoggedInObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> view.onUserNotLoggedIn(),
                        throwable -> view.showError(throwable.getMessage())));
    }
}
