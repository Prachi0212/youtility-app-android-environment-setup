package com.youtility.scene.fingerprintauth;

import android.app.Activity;

import com.multidots.fingerprintauth.FingerPrintAuthHelper;
import com.youtility.scene.fingerprintauth.base.FingerPrintPromptRouter;

public class FingerprintPromptRouterImpl implements FingerPrintPromptRouter {

    private ConfirmFingerprintDialog fingerprintDialog;
    private Activity activity;

    FingerprintPromptRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showConfirmFingerprintDialog(FingerPrintAuthHelper fingerPrintAuthHelper) {
        fingerprintDialog = new ConfirmFingerprintDialog(activity, fingerPrintAuthHelper);
        fingerprintDialog.show();
    }

    @Override
    public void onAuthenticated(boolean isSuccess, String message) {
        if (fingerprintDialog != null && fingerprintDialog.isShowing()) {
            fingerprintDialog.onAuthenticated(message, isSuccess);
        }
    }
}
