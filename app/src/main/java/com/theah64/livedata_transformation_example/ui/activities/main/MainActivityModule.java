package com.theah64.livedata_transformation_example.ui.activities.main;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final FragmentActivity fragmentActivity;

    public MainActivityModule(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Provides
    MainActivityViewModel provideViewModel() {
        return ViewModelProviders.of(fragmentActivity)
                .get(MainActivityViewModel.class);
    }

}