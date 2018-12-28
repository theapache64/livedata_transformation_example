package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import android.content.Context;

import com.theah64.livedata_transformation_example.data.remote.ApiRepository;
import com.theah64.livedata_transformation_example.di.base.ActivityModule;
import com.theah64.livedata_transformation_example.di.components.ApplicationComponent;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
public class SwitchMapTransformationActivityModule {

    private final FragmentActivity fragmentActivity;

    SwitchMapTransformationActivityModule(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Provides
    FragmentActivity provideFragmentActivity() {
        return fragmentActivity;
    }

    @Provides
    Context provideContext() {
        return fragmentActivity;
    }

    @Provides
    SwitchMapTransformationViewModelFactory provideSwitchMapTransformationViewModelFactory(ApiRepository apiRepository) {
        return new SwitchMapTransformationViewModelFactory(apiRepository);
    }

    @Provides
    SwitchMapTransformationViewModel provideSwitchMapTransformationViewModel(FragmentActivity fragmentActivity, SwitchMapTransformationViewModelFactory factory) {
        return ViewModelProviders.of(
                fragmentActivity,
                factory
        ).get(SwitchMapTransformationViewModel.class);
    }
}
