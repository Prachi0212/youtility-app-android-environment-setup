package com.youtility.scene.onboarding;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.youtility.R;
import com.youtility.common.base.BaseActivity;
import com.youtility.customview.CirclePageIndicator;
import com.youtility.scene.onboarding.base.OnboardingRouter;
import com.youtility.scene.onboarding.base.OnboardingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

public class OnboardingActivity extends BaseActivity implements OnboardingView {
    @Setter
    OnboardingRouter router;

    @BindView(R.id.pagerIndicator)
    CirclePageIndicator pagerIndicator;

    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        new OnboardingConfigurator().configure(this);
        Resources resources = getResources();
        String[] topTexts = resources.getStringArray(R.array.on_boarding_top_texts);
        String[] bottomTexts = resources.getStringArray(R.array.on_boarding_bottom_texts);
        int[] imgs = {R.drawable.carousel_finances, R.drawable.carousel_providers, R.drawable.carousel_bank, R.drawable.carousel_citizensadvice};
        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this, topTexts, bottomTexts, imgs);
        pager.setAdapter(adapter);
        pagerIndicator.setViewPager(pager);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @OnClick({R.id.btnSingUp, R.id.tvLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvLogin:
                router.goToLoginScreen();
                break;
            case R.id.btnSingUp:
                router.goToSignupScreen();
                break;
        }
    }
}
