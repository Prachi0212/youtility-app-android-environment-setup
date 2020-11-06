package com.youtility.common.base;

/**
 * Created by Mohit Rajput on 17/3/19.
 * Parent configurator of VIPER layers
 */
public interface Configurator<T extends BaseView> {
    public void configure(T view);
}
