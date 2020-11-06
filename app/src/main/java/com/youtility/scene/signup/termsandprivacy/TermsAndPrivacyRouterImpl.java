package com.youtility.scene.signup.termsandprivacy;

import android.app.Activity;
import android.content.Intent;

import com.youtility.common.Constants;
import com.youtility.scene.signup.firstname.SignUpFirstNameActivity;
import com.youtility.scene.signup.termsandprivacy.base.TermsAndPrivacyRouter;
import com.youtility.utils.IntentUtils;

public class TermsAndPrivacyRouterImpl implements TermsAndPrivacyRouter {

    private final Activity activity;

    TermsAndPrivacyRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToTermsOfService() {
        IntentUtils.openWebView(activity, Constants.Url.TERMS_AND_CONDITION);
    }

    @Override
    public void goToPrivacyPolicy() {
        IntentUtils.openWebView(activity, Constants.Url.PRIVACY_POLICY);
    }

    @Override
    public void goToSignUpStep() {
        Intent intent = new Intent(activity, SignUpFirstNameActivity.class);
        activity.startActivity(intent);
    }
}
