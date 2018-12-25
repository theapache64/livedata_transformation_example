package com.theah64.livedata_transformation_example.util;

import android.app.Application;

import com.theah64.livedata_transformation_example.di.components.ApplicationComponent;
import com.theah64.livedata_transformation_example.di.components.DaggerApplicationComponent;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;

public class App extends Application {

    public static final String BASE_URL = "http://theapache64.com/mock_api/get_json/lte_example/";
    private static ApplicationComponent daggerApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        daggerApplicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return daggerApplicationComponent;
    }
}
