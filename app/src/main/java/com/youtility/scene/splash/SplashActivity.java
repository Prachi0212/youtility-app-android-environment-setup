package com.youtility.scene.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.youtility.R;
import com.youtility.common.base.BaseActivity;
import com.youtility.energyswitchcui.scene.prompt.EnergyPromptActivity;
import com.youtility.scene.splash.base.SplashRouter;
import com.youtility.scene.splash.base.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Setter;

public class SplashActivity extends BaseActivity implements SplashView {

    private final static long ENTER_EXIT_DELAY_MS = 1500;
    private final static long EXIT_ANIMATION_DURATION_MS = 1500;
    @BindView(R.id.ivBackground)
    ImageView ivBackground;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.ivBottomTagline)
    ImageView ivBottomTagline;
    private Animation bgMoveToBottom, brandMoveToTop, hideAnimation;
    @Setter
    private SplashInteractor interactor;
    @Setter
    private SplashRouter router;
    private Animation.AnimationListener enterAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            startExitAnimationWithDelay();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setup();
        loadAnimations();
    }

    private void setup() {
        new SplashConfigurator().configure(this);
    }

    private void loadAnimations() {
        bgMoveToBottom = AnimationUtils.loadAnimation(context, R.anim.move_splash_bg);
        bgMoveToBottom.setAnimationListener(enterAnimationListener);
        brandMoveToTop = AnimationUtils.loadAnimation(context, R.anim.alpha_splash_brand);
        bgMoveToBottom.setAnimationListener(enterAnimationListener);
        hideAnimation = AnimationUtils.loadAnimation(context, R.anim.hide_with_animation);
        startEnterAnimationWithDelay();
    }

    private void startEnterAnimationWithDelay() {
        new Handler().postDelayed(() -> {
            ivBackground.startAnimation(bgMoveToBottom);
            ivLogo.startAnimation(brandMoveToTop);
            ivBottomTagline.startAnimation(brandMoveToTop);
            ivLogo.setVisibility(View.VISIBLE);
            ivBottomTagline.setVisibility(View.VISIBLE);
        }, ENTER_EXIT_DELAY_MS);
    }

    private void startExitAnimationWithDelay() {
        new Handler().postDelayed(() -> {
            ObjectAnimator moveUpLogo = ObjectAnimator.ofFloat(ivLogo, "y", ivLogo.getY(), -ivLogo.getHeight());
            moveUpLogo.setDuration(EXIT_ANIMATION_DURATION_MS);

            ObjectAnimator moveDownBackground = ObjectAnimator.ofFloat(ivBackground, "y", ivBackground.getY(), ivBackground.getHeight());
            moveDownBackground.setDuration(EXIT_ANIMATION_DURATION_MS);
            moveDownBackground.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    onAllAnimationsEnd();
                }
            });

            ivBottomTagline.startAnimation(hideAnimation);
            moveUpLogo.start();
            moveDownBackground.start();
        }, ENTER_EXIT_DELAY_MS);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    private void onAllAnimationsEnd() {
        interactor.loadUserSessionDetails();
    }

    @Override
    public void onUserAlreadyLoggedIn() {
        router.goToDashboardScreen();
    }

    @Override
    public void onUserNotLoggedIn() {
        //router.goToOnboardingScreen();
        router.goToEnergyCuiScreen();
    }
}
