package com.theah64.livedata_transformation_example.di.base;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final FragmentActivity fragmentActivity;

    public ActivityModule(FragmentActivity fragmentActivity) {
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
}
