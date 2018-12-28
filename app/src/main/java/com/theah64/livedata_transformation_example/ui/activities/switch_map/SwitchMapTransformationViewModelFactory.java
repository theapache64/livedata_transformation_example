package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import com.theah64.livedata_transformation_example.data.remote.ApiRepository;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class SwitchMapTransformationViewModelFactory implements ViewModelProvider.Factory {

    private ApiRepository apiRepository;

    @Inject
    SwitchMapTransformationViewModelFactory(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SwitchMapTransformationViewModel(apiRepository);
    }
}
