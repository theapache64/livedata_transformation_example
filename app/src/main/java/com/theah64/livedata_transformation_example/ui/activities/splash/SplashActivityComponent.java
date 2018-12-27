package com.theah64.livedata_transformation_example.ui.activities.splash;


import dagger.Component;

@Component(modules = {SplashActivityModule.class})
public interface SplashActivityComponent {
    void inject(SplashActivity splashActivity);
}
