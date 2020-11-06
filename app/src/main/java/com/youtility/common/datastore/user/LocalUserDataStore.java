package com.youtility.common.datastore.user;

import com.youtility.common.Constants;
import com.youtility.utils.SharedPreferenceUtils;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public class LocalUserDataStore implements UserDataStore {

    private final static String IS_LOGGED_IN = "is_logged_in";
    private final static String FIRST_NAME = "first_name";
    private final static String LAST_NAME = "last_name";
    private SharedPreferenceUtils preferenceUtils;

    public LocalUserDataStore(SharedPreferenceUtils preferenceUtils) {
        this.preferenceUtils = preferenceUtils;
    }

    @Override
    public Observable<Boolean> isUserLoggedIn() {
        return Observable.just(preferenceUtils.getBoolean(IS_LOGGED_IN, false));
    }

    @Override
    public Observable<String> getFirstName() {
        return Observable.just(preferenceUtils.getString(FIRST_NAME, Constants.General.EMPTY));
    }

    @Override
    public void saveFirstName(String firstName) {
        preferenceUtils.saveString(FIRST_NAME, firstName);
    }

    @Override
    public void saveLastName(String lastName) {
        preferenceUtils.saveString(LAST_NAME, lastName);
    }

    @Override
    public Observable<String> getLastName() {
        return Observable.just(preferenceUtils.getString(LAST_NAME, Constants.General.EMPTY));
    }
}
