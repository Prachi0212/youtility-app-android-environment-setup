package com.youtility.scene.signup.termsandprivacy;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.youtility.R;
import com.youtility.common.base.BaseActivity;
import com.youtility.scene.signup.termsandprivacy.base.TermsAndPrivacyRouter;
import com.youtility.scene.signup.termsandprivacy.base.TermsAndPrivacyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

public class TermsAndPrivacyActivity extends BaseActivity implements TermsAndPrivacyView {
    @Setter
    TermsAndPrivacyRouter router;

    @BindView(R.id.text_view_head)
    TextView textViewTCHead;

    @BindView(R.id.checkbox)
    CheckBox checkBox;

    @BindView(R.id.btnContinue)
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_privacy);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        new TermsAndPrivacyConfigurator().configure(this);
        Spannable wordToSpan = new SpannableString(getString(R.string.terms_and_privacy_head_text));
        wordToSpan.setSpan(new ForegroundColorSpan(getColor(R.color.colorAccent)), getString(R.string.terms_and_privacy_head_text).indexOf("our Terms & Privacy Policy"), getString(R.string.terms_and_privacy_head_text).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewTCHead.setText(wordToSpan);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btnContinue.setEnabled(isChecked);
        });
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

    @OnClick({R.id.layout_terms, R.id.layout_privacy_policy, R.id.btnContinue, R.id.image_view_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_terms:
                router.goToTermsOfService();
                break;
            case R.id.layout_privacy_policy:
                router.goToPrivacyPolicy();
                break;
            case R.id.btnContinue:
                router.goToSignUpStep();
                break;
            case R.id.image_view_close:
                onBackPressed();
                break;
        }
    }
}
