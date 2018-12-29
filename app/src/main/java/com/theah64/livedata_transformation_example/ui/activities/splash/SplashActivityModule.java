package com.theah64.livedata_transformation_example.ui.activities.splash;

import com.theah64.livedata_transformation_example.di.base.ActivityModule;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module(includes = ActivityModule.class)
class SplashActivityModule {

    @Provides
    SplashActivityViewModel provideSplashActivityViewModel(FragmentActivity fragmentActivity) {
        return ViewModelProviders.of(fragmentActivity)
                .get(SplashActivityViewModel.class);
    }

}
