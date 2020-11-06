package com.youtility.scene.signup.lastname;

import com.youtility.repository.base.UserRepository;
import com.youtility.scene.signup.lastname.base.SignUpLastNamePresenter;

import lombok.Setter;

/**
 * Created by Mohit Rajput on 29/3/19.
 */
public class SignUpLastNameInteractor {
    private UserRepository repository;
    @Setter
    private SignUpLastNamePresenter presenter;

    public SignUpLastNameInteractor(UserRepository repository) {
        this.repository = repository;
    }

    public void saveLastName(String lastName) {
        repository.saveLastName(lastName);
    }

    public void fetchLastNameIfStored() {
        presenter.presentLastName(repository.getLastName());
    }
}
