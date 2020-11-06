package com.youtility.scene.onboarding;

import com.youtility.common.base.Configurator;
import com.youtility.scene.onboarding.base.OnboardingRouter;

public class OnboardingConfigurator implements Configurator<OnboardingActivity> {

    @Override
    public void configure(OnboardingActivity view) {
        OnboardingRouter router = new OnboardingRouterImpl(view);
        view.setRouter(router);
    }
}
