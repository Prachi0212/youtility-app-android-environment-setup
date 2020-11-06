package com.youtility.scene.fingerprintauth.base;

import com.multidots.fingerprintauth.FingerPrintAuthHelper;

public interface FingerPrintPromptRouter {
    void showConfirmFingerprintDialog(FingerPrintAuthHelper fingerPrintAuthHelper);

    void onAuthenticated(boolean isSuccess, String message);
}
