package com.theah64.livedata_transformation_example.ui.activities.splash;

import com.theah64.livedata_transformation_example.di.base.BaseActivityModule;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
class SplashActivityModule extends BaseActivityModule {

    SplashActivityModule(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Provides
    SplashActivityViewModel provideSplashActivityViewModel() {
        return ViewModelProviders.of(getFragmentActivity())
                .get(SplashActivityViewModel.class);
    }

}
