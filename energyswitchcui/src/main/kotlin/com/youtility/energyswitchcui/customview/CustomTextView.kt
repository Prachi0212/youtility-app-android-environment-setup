package com.youtility.energyswitchcui.customview

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet


/**
 * Created by Mohit Rajput on 3/4/19.
 * Customized and common text view
 */
class CustomTextView : AppCompatTextView {

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
        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements()
    }

    private fun invalidateTextPaintAndMeasurements() {

    }
}
