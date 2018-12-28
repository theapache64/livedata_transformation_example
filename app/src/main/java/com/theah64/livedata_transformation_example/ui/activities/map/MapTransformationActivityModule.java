package com.theah64.livedata_transformation_example.ui.activities.map;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
class MapTransformationActivityModule {

    private final FragmentActivity fragmentActivity;

    MapTransformationActivityModule(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Provides
    MapTransformationViewModel provideMapTransformationViewModel() {
        return ViewModelProviders.of(fragmentActivity)
                .get(MapTransformationViewModel.class);
    }
}
