package com.youtility.snapshot;

import android.support.test.rule.ActivityTestRule;
import android.support.v4.view.ViewPager;

import com.facebook.testing.screenshot.Screenshot;
import com.youtility.R;
import com.youtility.scene.onboarding.OnboardingActivity;

import org.junit.Rule;
import org.junit.Test;

public class OnboardingScreenTest {
    @Rule
    public ActivityTestRule<OnboardingActivity> activityTestRule = new ActivityTestRule<>(OnboardingActivity.class, false, false);
    String name = getClass().getSimpleName();

    @Test
    public void testScreenshotEntireActivity() {
        OnboardingActivity activity = activityTestRule.launchActivity(null);
        snapShot(name+"-page1", activity);
        ViewPager pager = activity.findViewById(R.id.pager);
        changeItem(1, pager);
        snapShot(name+"-page2", activity);
        changeItem(2, pager);
        snapShot(name+"-page3", activity);
        changeItem(3, pager);
        snapShot(name+"-page4", activity);
    }

    private void changeItem(int position, ViewPager pager) {
        try {

            activityTestRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    pager.setCurrentItem(position);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void snapShot(String title, OnboardingActivity activity) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Screenshot.snapActivity(activity).setName(title).record();
    }

}
