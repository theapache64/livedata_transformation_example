package com.theah64.livedata_transformation_example.ui.splash;

import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SearchResponse.User provideUser() {
        return new SearchResponse.User("Shifar", "dfgsdfg");
    }

}
