package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import dagger.Component;

@Component(modules = SwitchMapTransformationActivityModule.class)
public interface SwitchMapTransformationActivityComponent {
    void inject(SwitchMapTransformationActivity activity);
}
