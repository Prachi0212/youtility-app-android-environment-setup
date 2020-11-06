package com.youtility.scene.signup.lastname.base;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 29/3/19.
 */
public interface SignUpLastNamePresenter {
    void presentLastName(Observable<String> lastNameObservable);
}