package com.youtility.snapshot;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.testing.screenshot.Screenshot;
import com.facebook.testing.screenshot.ViewHelpers;
import com.youtility.R;
import com.youtility.scene.fingerprintauth.ConfirmFingerprintDialog;
import com.youtility.scene.fingerprintauth.FingerprintPromptActivity;

import org.junit.Rule;
import org.junit.Test;

public class FingerprintPromptScreenTest {

    @Rule
    public ActivityTestRule<FingerprintPromptActivity> activityTestRule = new ActivityTestRule<>(FingerprintPromptActivity.class, false, false);
    String name = getClass().getSimpleName();

    @Test
    public void testScreenshotEntireActivity() {
        FingerprintPromptActivity activity = activityTestRule.launchActivity(null);
        Screenshot.snapActivity(activity).setName(name + "FullActivity").record();
    }

    private ConfirmFingerprintDialog dialog = null;

    @Test
    public void testFingerprintRegistrationDialog() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        View view = LayoutInflater.from(targetContext).inflate(R.layout.dialog_confirm_finger_print, null, false);
        ViewHelpers.setupView(view).setExactWidthDp(300).layout();
        Screenshot.snap(view).setName(name + "Fingerprint Registration").record();
        TextView tvCancel = view.findViewById(R.id.tvCancel);
        ImageView ivFingerPrint = view.findViewById(R.id.ivFingerPrint);
        ivFingerPrint.getBackground().setColorFilter(targetContext.getColor(R.color.colorGreen), PorterDuff.Mode.SRC);
        tvCancel.setTextColor(targetContext.getColor(R.color.colorGreen));
        tvCancel.setText(targetContext.getString(R.string.finger_recognized));
        Screenshot.snap(view).setName(name + "Fingerprint Registration Success").record();
        ivFingerPrint.getBackground().setColorFilter(targetContext.getColor(R.color.pink), PorterDuff.Mode.SRC);
        tvCancel.setTextColor(targetContext.getColor(R.color.pink));
        tvCancel.setText(targetContext.getString(R.string.finger_print_not_recognized));
        Screenshot.snap(view).setName(name + "Fingerprint Registration Failed").record();
    }
}