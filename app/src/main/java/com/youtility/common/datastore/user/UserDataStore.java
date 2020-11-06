package com.youtility.common.datastore.user;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public interface UserDataStore {
    Observable<Boolean> isUserLoggedIn();

    public Observable<String> getFirstName();

    public void saveFirstName(String firstName);

    public void saveLastName(String lastName);

    public Observable<String> getLastName();
}
