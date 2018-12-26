package com.theah64.livedata_transformation_example.util;

import android.app.Activity;
import android.app.Application;

import com.theah64.livedata_transformation_example.di.components.ApplicationComponent;
import com.theah64.livedata_transformation_example.di.components.DaggerApplicationComponent;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    public static final String BASE_URL = "http://theapache64.com/mock_api/get_json/lte_example/";

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(BASE_URL))
                .build();

        applicationComponent.inject(this);
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
