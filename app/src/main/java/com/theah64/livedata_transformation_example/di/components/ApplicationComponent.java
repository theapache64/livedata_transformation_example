package com.theah64.livedata_transformation_example.di.components;

import com.theah64.livedata_transformation_example.di.modules.BuildersModule;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;
import com.theah64.livedata_transformation_example.ui.activities.switch_map.SwitchMapActivityComponent;
import com.theah64.livedata_transformation_example.util.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        BuildersModule.class,
        NetworkModule.class
})
public interface ApplicationComponent {
    void inject(App app);
    SwitchMapActivityComponent.Builder switchMapBuilder();
}
