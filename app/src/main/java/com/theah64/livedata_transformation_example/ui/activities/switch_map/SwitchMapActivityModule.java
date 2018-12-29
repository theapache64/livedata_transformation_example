package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import com.theah64.livedata_transformation_example.data.remote.ApiRepository;
import com.theah64.livedata_transformation_example.di.base.ActivityModule;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ActivityModule.class})
public class SwitchMapActivityModule {

    @Provides
    SwitchMapViewModelFactory provideSwitchMapTransformationViewModelFactory(ApiRepository apiRepository) {
        return new SwitchMapViewModelFactory(apiRepository);
    }

    @Provides
    SwitchMapViewModel provideSwitchMapTransformationViewModel(FragmentActivity fragmentActivity, SwitchMapViewModelFactory factory) {
        return ViewModelProviders.of(
                fragmentActivity,
                factory
        ).get(SwitchMapViewModel.class);
    }
}
