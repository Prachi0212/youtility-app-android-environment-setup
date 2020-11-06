package com.youtility.scene.signup.lastname;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.youtility.R;
import com.youtility.common.base.BaseActivity;
import com.youtility.customview.CustomButton;
import com.youtility.customview.CustomTextView;
import com.youtility.scene.signup.lastname.base.SignUpLastNameRouter;
import com.youtility.scene.signup.lastname.base.SignUpLastNameView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

public class SignUpLastNameActivity extends BaseActivity implements SignUpLastNameView {
    @Setter
    SignUpLastNameRouter router;
    @Setter
    SignUpLastNameInteractor interactor;

    @BindView(R.id.etLastName)
    TextInputEditText etLastName;

    @BindView(R.id.btnContinue)
    CustomButton btnContinue;

    @BindView(R.id.tvHeader)
    CustomTextView tvHeader;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            btnContinue.setEnabled(s.length() > 1);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_last_name);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        new SignUpLastNameConfigurator().configure(this);
        initHeader();
        interactor.fetchLastNameIfStored();
    }

    private void initHeader() {
        String lastNameHead = getString(R.string.last_name_head);
        etLastName.addTextChangedListener(textWatcher);
        Spannable wordToSpan = new SpannableString(lastNameHead);
        wordToSpan.setSpan(new ForegroundColorSpan(getColor(R.color.colorAccent)), lastNameHead.indexOf(getString(R.string.last_name_small)), lastNameHead.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvHeader.setText(wordToSpan);
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

    @OnClick({R.id.btnBack, R.id.btnContinue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                onBackPressed();
                break;
            case R.id.btnContinue:
                interactor.saveLastName(getLastName());
                router.goToFingerprintPromptScreen();
                break;
        }
    }

    private String getLastName() {
        return etLastName.getText().toString().trim();
    }

    @Override
    public void showLastName(String lastName) {
        etLastName.setText(lastName);
        etLastName.setSelection(lastName.length());
    }
}
