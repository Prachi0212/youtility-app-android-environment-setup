package com.youtility.repository;

import com.youtility.common.datastore.user.UserDataStore;
import com.youtility.repository.base.UserRepository;

import io.reactivex.Observable;

/**
 * Created by Mohit Rajput on 20/3/19.
 * Current users profile data provider
 */
public class UserRepositoryImpl implements UserRepository {
    private UserDataStore localUserDataStore;

    public UserRepositoryImpl(UserDataStore localUserDataStore) {
        this.localUserDataStore = localUserDataStore;
    }

    public Observable<Boolean> isUserLoggedIn() {
        return localUserDataStore.isUserLoggedIn();
    }

    @Override
    public Observable<String> getFirstName() {
        return localUserDataStore.getFirstName();
    }

    @Override
    public void saveFirstName(String firstName) {
        localUserDataStore.saveFirstName(firstName);
    }

    @Override
    public void saveLastName(String lastName) {
        localUserDataStore.saveLastName(lastName);
    }

    @Override
    public Observable<String> getLastName() {
        return localUserDataStore.getLastName();
    }
}
