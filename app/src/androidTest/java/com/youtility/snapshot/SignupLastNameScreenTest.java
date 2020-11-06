package com.youtility.snapshot;

import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import com.facebook.testing.screenshot.Screenshot;
import com.youtility.R;
import com.youtility.scene.signup.lastname.SignUpLastNameActivity;

import org.junit.Rule;
import org.junit.Test;

public class SignupLastNameScreenTest {

    @Rule
    public ActivityTestRule<SignUpLastNameActivity> activityTestRule = new ActivityTestRule<>(SignUpLastNameActivity.class, false, false);
    String name = getClass().getSimpleName();

    @Test
    public void testScreenshotEntireActivity() {
        SignUpLastNameActivity activity = activityTestRule.launchActivity(null);
        Screenshot.snapActivity(activity).setName(name + "1").record();
        EditText editText = activity.findViewById(R.id.etLastName);
        activity.runOnUiThread(() -> {
            editText.append("Last Name");
        });
        Screenshot.snapActivity(activity).setName(name + " 2").record();
    }
}