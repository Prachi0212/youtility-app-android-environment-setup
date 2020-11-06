package com.youtility.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    protected Context context;
    protected String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "stopped");
    }
}