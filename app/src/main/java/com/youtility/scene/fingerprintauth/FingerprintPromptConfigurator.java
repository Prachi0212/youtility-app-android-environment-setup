package com.youtility.scene.fingerprintauth;

import com.youtility.common.base.Configurator;
import com.youtility.scene.fingerprintauth.base.FingerPrintPromptRouter;

public class FingerprintPromptConfigurator implements Configurator<FingerprintPromptActivity> {

    @Override
    public void configure(FingerprintPromptActivity view) {
        FingerPrintPromptRouter router = new FingerprintPromptRouterImpl(view);
        view.setRouter(router);
    }
}
