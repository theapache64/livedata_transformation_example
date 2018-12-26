package com.theah64.livedata_transformation_example.ui.splash;


import dagger.Subcomponent;

@Subcomponent(modules = {SplashActivityModule.class})
public interface SplashActivityComponent {
    void inject(SplashActivity splashActivity);
}
