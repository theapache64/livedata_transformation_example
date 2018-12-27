package com.theah64.livedata_transformation_example.ui.activities.map;

import dagger.Component;

@Component(modules = MapTransformationActivityModule.class)
public interface MapTransformationActivityComponent {
    void inject(MapTransformationActivity mapTransformationActivity);
}
