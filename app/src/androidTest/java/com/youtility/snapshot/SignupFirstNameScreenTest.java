package com.youtility.snapshot;

import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import com.facebook.testing.screenshot.Screenshot;
import com.youtility.R;
import com.youtility.scene.signup.firstname.SignUpFirstNameActivity;

import org.junit.Rule;
import org.junit.Test;

public class SignupFirstNameScreenTest {

    @Rule
    public ActivityTestRule<SignUpFirstNameActivity> activityTestRule = new ActivityTestRule<>(SignUpFirstNameActivity.class, false, false);
    String name = getClass().getSimpleName();

    @Test
    public void testScreenshotEntireActivity() {
        SignUpFirstNameActivity activity = activityTestRule.launchActivity(null);
        Screenshot.snapActivity(activity).setName(name + "1").record();
        EditText editTextFirstName = activity.findViewById(R.id.etFirstName);
        activity.runOnUiThread(() -> {
            editTextFirstName.append("First Name");
        });
        Screenshot.snapActivity(activity).setName(name+" 2").record();
    }
}