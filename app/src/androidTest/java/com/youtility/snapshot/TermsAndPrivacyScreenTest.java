package com.youtility.snapshot;

import android.support.test.rule.ActivityTestRule;
import android.widget.CheckBox;

import com.facebook.testing.screenshot.Screenshot;
import com.youtility.R;
import com.youtility.scene.signup.termsandprivacy.TermsAndPrivacyActivity;

import org.junit.Rule;
import org.junit.Test;

public class TermsAndPrivacyScreenTest {

    @Rule
    public ActivityTestRule<TermsAndPrivacyActivity> activityTestRule = new ActivityTestRule<>(TermsAndPrivacyActivity.class, false, false);
    String name = getClass().getSimpleName();

    @Test
    public void testScreenshotEntireActivity() {
        TermsAndPrivacyActivity activity = activityTestRule.launchActivity(null);
        Screenshot.snapActivity(activity).setName(name + "1").record();
        CheckBox checkBox = activity.findViewById(R.id.checkbox);
        activity.runOnUiThread(() -> {
            checkBox.setChecked(true);
        });
        Screenshot.snapActivity(activity).setName(name+" 2").record();
    }
}