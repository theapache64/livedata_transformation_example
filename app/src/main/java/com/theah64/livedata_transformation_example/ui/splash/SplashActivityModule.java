package com.theah64.livedata_transformation_example.ui.splash;

import com.theah64.livedata_transformation_example.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
class SplashActivityModule {

    @PerActivity
    @Provides
    SplashActivityViewModel provideSplashActivityViewModel() {
        return null;
    }

}
