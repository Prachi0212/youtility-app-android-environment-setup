package com.youtility.splash;

import com.youtility.repository.base.UserRepository;
import com.youtility.scene.splash.SplashInteractor;
import com.youtility.scene.splash.base.SplashPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class SplashInteractorTest {
    private SplashInteractor splashInteractor;
    private MockSplashPresenter mockSplashPresenter;
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        splashInteractor = new SplashInteractor(userRepository);
        mockSplashPresenter = new MockSplashPresenter();
        splashInteractor.setPresenter(mockSplashPresenter);
    }

    @Test
    public void testIsUserLoggedIn_obseravleShouldBeFalseIfUserIsNotLoggedIn() {
        when(userRepository.isUserLoggedIn()).thenReturn(Observable.just(Boolean.FALSE));

        splashInteractor.loadUserSessionDetails();
        mockSplashPresenter.isLoggedInObservable.test().assertValue(isLoggedIn -> !isLoggedIn).assertComplete();
    }

    @Test
    public void testIsUserLoggedIn_obseravleShouldBeTrueIfUserIsLoggedIn() {
        when(userRepository.isUserLoggedIn()).thenReturn(Observable.just(Boolean.TRUE));

        splashInteractor.loadUserSessionDetails();
        mockSplashPresenter.isLoggedInObservable.test().assertValue(isLoggedIn -> isLoggedIn).assertComplete();
    }

    private class MockSplashPresenter implements SplashPresenter {

        private Observable<Boolean> isLoggedInObservable;

        @Override
        public void presentUserSessionDetails(Observable<Boolean> isLoggedInObservable) {
            this.isLoggedInObservable = isLoggedInObservable;
        }
    }
}