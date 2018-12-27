package com.theah64.livedata_transformation_example.di.modules;

import com.theah64.livedata_transformation_example.data.remote.ApiInterface;
import com.theah64.livedata_transformation_example.data.remote.ApiRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Singleton
    @Provides
    ApiRepository provideApiRepository(ApiInterface apiInterface) {
        return new ApiRepository(apiInterface);
    }
}
