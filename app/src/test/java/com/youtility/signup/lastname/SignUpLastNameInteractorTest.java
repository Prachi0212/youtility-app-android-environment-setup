package com.youtility.signup.lastname;

import com.youtility.repository.base.UserRepository;
import com.youtility.scene.signup.lastname.SignUpLastNameInteractor;
import com.youtility.scene.signup.lastname.base.SignUpLastNamePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class SignUpLastNameInteractorTest {
    private SignUpLastNameInteractor interactor;
    private MockSignUpLastNamePresenter presenter;
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        interactor = new SignUpLastNameInteractor(userRepository);
        presenter = new MockSignUpLastNamePresenter();
        interactor.setPresenter(presenter);
    }

    @Test
    public void testStoredUserName_obseravleShouldContainLastName() {
        final String testName = "Martin";
        when(userRepository.getLastName()).thenReturn(Observable.just(testName));

        interactor.fetchLastNameIfStored();
        presenter.lastNameObservable.test().assertValue(lastName -> lastName.equals(testName)).assertComplete();
    }

    @Test
    public void testNotStoredUserName_obseravleShouldBeNull() {
        when(userRepository.getLastName()).thenReturn(null);

        interactor.fetchLastNameIfStored();
        Assert.assertNull(presenter.lastNameObservable);
    }

    private class MockSignUpLastNamePresenter implements SignUpLastNamePresenter {
        private Observable<String> lastNameObservable;

        @Override
        public void presentLastName(Observable<String> lastNameObservable) {
            this.lastNameObservable = lastNameObservable;
        }
    }
}