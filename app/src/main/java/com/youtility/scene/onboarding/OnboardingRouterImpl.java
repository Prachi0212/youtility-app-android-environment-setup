package com.youtility.scene.onboarding;

import android.app.Activity;
import android.content.Intent;

import com.youtility.scene.onboarding.base.OnboardingRouter;
import com.youtility.scene.signup.termsandprivacy.TermsAndPrivacyActivity;

public class OnboardingRouterImpl implements OnboardingRouter {

    private Activity activity;

    OnboardingRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToLoginScreen() {
    }

    @Override
    public void goToSignupScreen() {
        Intent intent = new Intent(activity, TermsAndPrivacyActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
