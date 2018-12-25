package com.theah64.livedata_transformation_example.di.components;

import com.theah64.livedata_transformation_example.di.modules.NetworkModule;
import com.theah64.livedata_transformation_example.ui.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {
    void inject(SplashActivity splashActivity);
}
