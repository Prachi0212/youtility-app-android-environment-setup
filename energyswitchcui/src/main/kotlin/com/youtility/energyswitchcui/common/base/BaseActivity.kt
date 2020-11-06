package com.youtility.energyswitchcui.common.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

open class BaseActivity : AppCompatActivity() {

    protected lateinit var context: Context
    protected var TAG = javaClass.getSimpleName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "started")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "stopped")
    }
}