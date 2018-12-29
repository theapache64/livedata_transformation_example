package com.theah64.livedata_transformation_example.ui.activities.map;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module
class MapActivityModule {

    private final FragmentActivity fragmentActivity;

    MapActivityModule(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Provides
    MapActivityViewModel provideMapTransformationViewModel() {
        return ViewModelProviders.of(fragmentActivity)
                .get(MapActivityViewModel.class);
    }
}
