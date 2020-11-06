package com.youtility.scene.fingerprintauth;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.youtility.R;
import com.youtility.common.base.BaseActivity;
import com.youtility.scene.fingerprintauth.base.FingerPrintPromptRouter;
import com.youtility.scene.fingerprintauth.base.FingerprintPromptView;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

public class FingerprintPromptActivity extends BaseActivity implements FingerprintPromptView, FingerPrintAuthCallback {
    @Setter
    FingerPrintPromptRouter router;

    @BindView(R.id.tvHead)
    TextView tvHead;
    private FingerPrintAuthHelper fingerPrintAuthHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_prompt);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        new FingerprintPromptConfigurator().configure(this);
        String fingerprintPromptText = getString(R.string.finger_print_prompt_head);
        Spannable wordtoSpan = new SpannableString(fingerprintPromptText);
        wordtoSpan.setSpan(new ForegroundColorSpan(getColor(R.color.colorAccent)), fingerprintPromptText.indexOf(getString(R.string.your_finger_print)), fingerprintPromptText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvHead.setText(wordtoSpan);
        fingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(this, this);
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

    @OnClick({R.id.tvNoThanks, R.id.btnBack, R.id.btnUseFingerprint})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUseFingerprint:
                fingerPrintAuthHelper.startAuth();
                router.showConfirmFingerprintDialog(fingerPrintAuthHelper);
                break;
            case R.id.btnBack:
                onBackPressed();
                break;
            case R.id.tvNoThanks:
                break;
        }
    }

    @Override
    public void onNoFingerPrintHardwareFound() {
        router.onAuthenticated(true, getString(R.string.no_fingerprint));
    }

    @Override
    public void onNoFingerPrintRegistered() {
        router.onAuthenticated(false, getString(R.string.register_atleas_one_fingerprint));
    }

    @Override
    public void onBelowMarshmallow() {

    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        router.onAuthenticated(true, getString(R.string.finger_recognized));

    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {
        router.onAuthenticated(false, getString(R.string.finger_print_not_recognized));
    }

    @Override
    protected void onPause() {
        super.onPause();
        fingerPrintAuthHelper.stopAuth();
    }
}
