package com.youtility.customview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


/**
 * Created by Mohit Rajput on 11/12/17.
 * Customized and common edit text
 */
public class CustomEditText extends AppCompatEditText {

    public CustomEditText(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @SuppressWarnings("unused")
    private void init(AttributeSet attrs, int defStyle) {
        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    public void setError(CharSequence error) {
        super.setError(error);
        requestFocus();
    }

    @Override
    public void setError(CharSequence error, Drawable icon) {
        super.setError(error, icon);
        requestFocus();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(oldw, oldh, oldw, oldh);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }
}
