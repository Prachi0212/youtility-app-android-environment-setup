package com.youtility.scene.signup.lastname;

import android.app.Activity;
import android.content.Intent;

import com.youtility.scene.fingerprintauth.FingerprintPromptActivity;
import com.youtility.scene.signup.lastname.base.SignUpLastNameRouter;

public class SingUpLastNameRouterImpl implements SignUpLastNameRouter {
    private final Activity activity;

    SingUpLastNameRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToFingerprintPromptScreen() {
        Intent intent = new Intent(activity, FingerprintPromptActivity.class);
        activity.startActivity(intent);
    }
}
