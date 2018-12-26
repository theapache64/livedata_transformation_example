package com.theah64.livedata_transformation_example.di.modules;

import com.theah64.livedata_transformation_example.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();
}
