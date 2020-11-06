package com.youtility.repository.base;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 20/3/19.
 * Current users profile data provider
 */
public interface UserRepository {
    public Observable<Boolean> isUserLoggedIn();

    public Observable<String> getFirstName();

    public void saveFirstName(String firstName);

    public void saveLastName(String lastName);

    public Observable<String> getLastName();
}
