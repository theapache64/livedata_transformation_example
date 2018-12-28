package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import com.theah64.livedata_transformation_example.di.base.ActivityModule;

import dagger.Subcomponent;

@Subcomponent(modules = SwitchMapTransformationActivityModule.class)
public interface SwitchMapTransformationActivityComponent {
    void inject(SwitchMapTransformationActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder activityModule(ActivityModule activityModule);
        Builder switchMapTransformationActivityModule(SwitchMapTransformationActivityModule activityModule);
        SwitchMapTransformationActivityComponent build();
    }
}
