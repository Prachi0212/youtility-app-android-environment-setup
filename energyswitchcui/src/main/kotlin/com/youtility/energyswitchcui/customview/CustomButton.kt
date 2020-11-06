package com.youtility.energyswitchcui.customview

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet


/**
 * Created by Mohit Rajput on 3/4/18.
 * Customized and common button
 */
class CustomButton : AppCompatButton {

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        isAllCaps = false
        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements()
    }

    private fun invalidateTextPaintAndMeasurements() {

    }

    override fun setEnabled(enabled: Boolean) {
        if (enabled) {
            alpha = 1.0f
        } else {
            alpha = 0.6f
        }
        super.setEnabled(enabled)
    }
}
