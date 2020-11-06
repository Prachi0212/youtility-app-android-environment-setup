package com.youtility.scene.splash;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;

import com.youtility.energyswitchcui.scene.prompt.EnergyPromptActivity;
import com.youtility.scene.onboarding.OnboardingActivity;
import com.youtility.scene.splash.base.SplashRouter;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public class SplashRouterImpl implements SplashRouter {

    private Activity activity;

    SplashRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToOnboardingScreen() {
        Intent intent = new Intent(activity, OnboardingActivity.class);
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
        activity.finish();
    }

    @Override
    public void goToDashboardScreen() {

    }

    @Override
    public void goToEnergyCuiScreen() {
        Intent intent = new Intent(activity, EnergyPromptActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}