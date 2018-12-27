package com.theah64.livedata_transformation_example.ui.activities.splash;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    private final FragmentActivity fragmentActivity;

    public SplashActivityModule(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Provides
    SplashActivityViewModel provideViewModel() {
        return ViewModelProviders.of(fragmentActivity)
                .get(SplashActivityViewModel.class);
    }

}
