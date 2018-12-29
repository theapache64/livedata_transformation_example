package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import com.theah64.livedata_transformation_example.di.base.ActivityModule;

import dagger.Subcomponent;

@Subcomponent(modules = SwitchMapActivityModule.class)
public interface SwitchMapActivityComponent {
    void inject(SwitchMapActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder activityModule(ActivityModule activityModule);
        Builder switchMapTransformationActivityModule(SwitchMapActivityModule activityModule);
        SwitchMapActivityComponent build();
    }
}
