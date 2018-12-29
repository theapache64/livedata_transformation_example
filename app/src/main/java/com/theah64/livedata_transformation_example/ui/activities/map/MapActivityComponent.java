package com.theah64.livedata_transformation_example.ui.activities.map;

import dagger.Component;

@Component(modules = MapActivityModule.class)
public interface MapActivityComponent {
    void inject(MapActivity mapTransformationActivity);
}
