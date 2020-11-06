package com.youtility.scene.fingerprintauth;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.youtility.R;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmFingerprintDialog extends AppCompatDialog {
    private final Context context;

    @BindView(R.id.tvCancel)
    TextView tvCancel;

    @BindView(R.id.ivFingerPrint)
    ImageView ivFingerPrint;

    FingerPrintAuthHelper fingerPrintAuthHelper;

    public ConfirmFingerprintDialog(Context context, FingerPrintAuthHelper fingerPrintAuthHelper) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.fingerPrintAuthHelper = fingerPrintAuthHelper;
        init();
    }

    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setGravity(Gravity.BOTTOM);
        setContentView(R.layout.dialog_confirm_finger_print);
        ButterKnife.bind(this);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setCancelable(false);
    }

    @OnClick(R.id.tvCancel)
    public void onCancel() {
        dismiss();
        fingerPrintAuthHelper.stopAuth();
    }

    public void onAuthenticated(String message, boolean isSuccess) {
        Drawable background = ivFingerPrint.getBackground();
        if (isSuccess) {
            background.setColorFilter(context.getColor(R.color.colorGreen), PorterDuff.Mode.SRC);
            tvCancel.setTextColor(context.getColor(R.color.colorGreen));
            tvCancel.setText(context.getString(R.string.finger_recognized));
        } else {
            background.setColorFilter(context.getColor(R.color.pink), PorterDuff.Mode.SRC);
            tvCancel.setTextColor(context.getColor(R.color.pink));
            tvCancel.setText(context.getString(R.string.finger_print_not_recognized));
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvCancel.performClick();
            }
        }, 1000);
    }
}
