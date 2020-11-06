package com.youtility.scene.signup.lastname;

import com.youtility.common.base.Presenter;
import com.youtility.scene.signup.lastname.base.SignUpLastNamePresenter;
import com.youtility.scene.signup.lastname.base.SignUpLastNameView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Setter;

/**
 * Created by Mohit Rajput on 29/3/19.
 */
public class SignUpLastNamePresenterImpl extends Presenter implements SignUpLastNamePresenter {
    @Setter
    private SignUpLastNameView view;

    @Override
    public void presentLastName(Observable<String> lastNameObservable) {
        addDisposable(lastNameObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> view.showLastName(result),
                        throwable -> view.showError(throwable.getMessage())));
    }
}
