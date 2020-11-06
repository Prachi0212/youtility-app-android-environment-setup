package com.youtility.scene.signup.firstname;

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
import com.youtility.scene.signup.firstname.base.SignUpFirstNameRouter;
import com.youtility.scene.signup.firstname.base.SignUpFirstNameView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

public class SignUpFirstNameActivity extends BaseActivity implements SignUpFirstNameView {
    @Setter
    SignUpFirstNameRouter router;

    @BindView(R.id.etFirstName)
    TextInputEditText etFirstName;

    @BindView(R.id.btnContinue)
    CustomButton btnContinue;

    @BindView(R.id.tvHeader)
    CustomTextView tvHeader;
    @Setter
    private SignUpFirstNameInteractor interactor;

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
        setContentView(R.layout.activity_singup_first_name);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        new SignUpFirstNameConfigurator().configure(this);
        initHeader();
        interactor.fetchFirstNameIfStored();
    }

    private void initHeader() {
        String firstNameHead = getString(R.string.first_name_head);
        etFirstName.addTextChangedListener(textWatcher);
        Spannable wordToSpan = new SpannableString(firstNameHead);
        wordToSpan.setSpan(new ForegroundColorSpan(getColor(R.color.colorAccent)), firstNameHead.indexOf(getString(R.string.first_name_question_mark)), firstNameHead.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                interactor.saveFirstName(getFirstName());
                router.goToSignUpLastNameScreen();
                break;
        }
    }

    private String getFirstName() {
        return etFirstName.getText().toString().trim();
    }

    @Override
    public void showFirstName(String firstName) {
        etFirstName.setText(firstName);
        etFirstName.setSelection(firstName.length());
    }
}
