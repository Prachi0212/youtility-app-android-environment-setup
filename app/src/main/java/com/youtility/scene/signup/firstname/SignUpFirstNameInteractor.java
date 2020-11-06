package com.youtility.scene.signup.firstname;

import com.youtility.repository.base.UserRepository;
import com.youtility.scene.signup.firstname.base.SignUpFirstNamePresenter;

import lombok.Setter;

/**
 * Created by Mohit Rajput on 29/3/19.
 */
public class SignUpFirstNameInteractor {
    private UserRepository repository;
    @Setter
    private SignUpFirstNamePresenter presenter;

    public SignUpFirstNameInteractor(UserRepository repository) {
        this.repository = repository;
    }

    public void saveFirstName(String firstName) {
        repository.saveFirstName(firstName);
    }

    public void fetchFirstNameIfStored() {
        presenter.presentFirstName(repository.getFirstName());
    }
}
