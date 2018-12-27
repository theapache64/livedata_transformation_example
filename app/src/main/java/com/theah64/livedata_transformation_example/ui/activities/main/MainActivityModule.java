package com.theah64.livedata_transformation_example.ui.activities.main;

import com.theah64.livedata_transformation_example.di.base.BaseActivityModule;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule extends BaseActivityModule<MainActivityViewModel> {


    public MainActivityModule(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    protected MainActivityViewModel getViewModel() {
        return ViewModelProviders.of(getFragmentActivity())
                .get(MainActivityViewModel.class);
    }

    @Provides
    MainActivityViewModel provideMainActivityViewModel() {
        return getViewModel();
    }

}