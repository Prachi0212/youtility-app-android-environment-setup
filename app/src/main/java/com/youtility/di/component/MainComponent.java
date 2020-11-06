package com.youtility.di.component;

import android.content.Context;

import com.youtility.YoutilityApplication;
import com.youtility.di.ApplicationContext;
import com.youtility.di.ApplicationScope;
import com.youtility.di.module.AppModule;
import com.youtility.di.module.NetworkModule;

import dagger.Component;

/**
 * Created by Mohit Rajput on 13/3/19.
 * Main component of dagger to inject must have dependencies i.e. context and API calling interface
 */

@ApplicationScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface MainComponent {
    @ApplicationContext
    Context getContext();

    void inject(YoutilityApplication youtilityApplication);
}
