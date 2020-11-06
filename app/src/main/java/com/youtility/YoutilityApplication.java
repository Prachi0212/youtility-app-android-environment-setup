package com.youtility;

import android.app.Application;
import android.content.Context;

import com.youtility.R;
import com.youtility.di.component.DaggerMainComponent;
import com.youtility.di.component.MainComponent;
import com.youtility.di.module.AppModule;
import com.youtility.di.module.NetworkModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Mohit Rajput on 12/3/19.
 */
public class YoutilityApplication extends Application {
    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        initDependencies();
    }

    private void initDependencies() {
        mainComponent = DaggerMainComponent.builder().
                appModule(new AppModule(this))
                .networkModule(new NetworkModule(getString(R.string.api_key)))
                .build();
        mainComponent.inject(this);
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }
}
