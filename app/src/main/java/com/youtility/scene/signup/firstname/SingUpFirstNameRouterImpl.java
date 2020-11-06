package com.youtility.scene.signup.firstname;

import android.app.Activity;
import android.content.Intent;

import com.youtility.scene.signup.firstname.base.SignUpFirstNameRouter;
import com.youtility.scene.signup.lastname.SignUpLastNameActivity;

public class SingUpFirstNameRouterImpl implements SignUpFirstNameRouter {
    private final Activity activity;

    SingUpFirstNameRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToSignUpLastNameScreen() {
        Intent intent = new Intent(activity, SignUpLastNameActivity.class);
        activity.startActivity(intent);
    }
}
