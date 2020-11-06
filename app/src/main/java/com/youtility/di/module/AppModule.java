package com.youtility.di.module;

import android.content.Context;

import com.youtility.di.ApplicationContext;
import com.youtility.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohit Rajput on 12/2/19.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context getContext() {
        return context;
    }
}