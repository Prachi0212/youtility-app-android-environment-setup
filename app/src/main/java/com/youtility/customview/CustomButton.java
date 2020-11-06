package com.youtility.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;


/**
 * Created by Mohit Rajput on 11/12/17.
 * Customized and common button
 */
@SuppressLint("AppCompatCustomView")
public class CustomButton extends Button {

    public CustomButton(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @SuppressWarnings("unused")
    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        setAllCaps(false);
        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    public void setEnabled(boolean enabled) {
        if (enabled) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.6f);
        }
        super.setEnabled(enabled);
    }
}
