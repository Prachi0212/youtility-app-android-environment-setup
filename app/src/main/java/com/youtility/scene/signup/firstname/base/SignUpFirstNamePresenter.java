package com.youtility.scene.signup.firstname.base;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 29/3/19.
 */
public interface SignUpFirstNamePresenter {
    void presentFirstName(Observable<String> fistNameObservable);
}