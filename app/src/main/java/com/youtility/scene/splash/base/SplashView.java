package com.youtility.scene.splash.base;

import com.youtility.common.base.BaseView;

/**
 * Created by Mohit Rajput on 20/3/19.
 */
public interface SplashView extends BaseView {
    void onUserAlreadyLoggedIn();

    void onUserNotLoggedIn();
}
