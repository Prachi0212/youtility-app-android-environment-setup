package com.youtility.scene.signup.termsandprivacy;

import com.youtility.common.base.Configurator;
import com.youtility.scene.signup.termsandprivacy.base.TermsAndPrivacyRouter;

public class TermsAndPrivacyConfigurator implements Configurator<TermsAndPrivacyActivity> {

    @Override
    public void configure(TermsAndPrivacyActivity view) {
        TermsAndPrivacyRouter router = new TermsAndPrivacyRouterImpl(view);
        view.setRouter(router);
    }
}
