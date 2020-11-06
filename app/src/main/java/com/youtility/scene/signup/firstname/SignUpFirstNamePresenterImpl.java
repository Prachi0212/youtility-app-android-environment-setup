package com.youtility.scene.signup.firstname;

import com.youtility.common.base.Presenter;
import com.youtility.scene.signup.firstname.base.SignUpFirstNamePresenter;
import com.youtility.scene.signup.firstname.base.SignUpFirstNameView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Setter;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public class SignUpFirstNamePresenterImpl extends Presenter implements SignUpFirstNamePresenter {
    @Setter
    private SignUpFirstNameView view;

    @Override
    public void presentFirstName(Observable<String> fistNameObservable) {
        addDisposable(fistNameObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> view.showFirstName(result),
                        throwable -> view.showError(throwable.getMessage())));
    }
}
