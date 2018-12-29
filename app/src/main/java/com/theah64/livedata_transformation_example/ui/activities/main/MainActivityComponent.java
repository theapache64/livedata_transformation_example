package com.theah64.livedata_transformation_example.ui.activities.main;

import com.theah64.livedata_transformation_example.di.scopes.PerActivity;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
