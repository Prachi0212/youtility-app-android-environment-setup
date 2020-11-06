package com.youtility.signup.firstname;

import com.youtility.repository.base.UserRepository;
import com.youtility.scene.signup.firstname.SignUpFirstNameInteractor;
import com.youtility.scene.signup.firstname.base.SignUpFirstNamePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class SignUpFirstNameInteractorTest {
    private SignUpFirstNameInteractor interactor;
    private MockSignUpFirstNamePresenter presenter;
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        interactor = new SignUpFirstNameInteractor(userRepository);
        presenter = new MockSignUpFirstNamePresenter();
        interactor.setPresenter(presenter);
    }

    @Test
    public void testStoredUserName_obseravleShouldContainFirstName() {
        final String testName = "John";
        when(userRepository.getFirstName()).thenReturn(Observable.just(testName));

        interactor.fetchFirstNameIfStored();
        presenter.fistNameObservable.test().assertValue(firstName -> firstName.equals(testName)).assertComplete();
    }

    @Test
    public void testNotStoredUserName_obseravleShouldBeNull() {
        when(userRepository.getFirstName()).thenReturn(null);

        interactor.fetchFirstNameIfStored();
        Assert.assertNull(presenter.fistNameObservable);
    }

    private class MockSignUpFirstNamePresenter implements SignUpFirstNamePresenter {
        private Observable<String> fistNameObservable;

        @Override
        public void presentFirstName(Observable<String> fistNameObservable) {
            this.fistNameObservable = fistNameObservable;
        }
    }
}