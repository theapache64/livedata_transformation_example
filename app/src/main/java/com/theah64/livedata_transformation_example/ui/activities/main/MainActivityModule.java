package com.theah64.livedata_transformation_example.ui.activities.main;

import com.theah64.livedata_transformation_example.di.base.ActivityModule;
import com.theah64.livedata_transformation_example.di.modules.RecyclerViewModule;
import com.theah64.livedata_transformation_example.ui.adapters.MenuAdapter;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

@Module(includes = {
        RecyclerViewModule.class,
        ActivityModule.class
})
class MainActivityModule {

    private final MenuAdapter.Callback menuAdapterCallback;

    MainActivityModule(MenuAdapter.Callback menuAdapterCallback) {
        this.menuAdapterCallback = menuAdapterCallback;
    }

    @Provides
    MainActivityViewModel provideMainActivityViewModel(
            FragmentActivity fragmentActivity,
            MainActivityViewModelFactory factory
    ) {

        return ViewModelProviders.of(fragmentActivity, factory)
                .get(MainActivityViewModel.class);
    }


    @Provides
    MenuAdapter.Callback provideMenuAdapterCallback() {
        return menuAdapterCallback;
    }

    @Provides
    MainActivityViewModelFactory provideViewModelFactory(MenuAdapter menuAdapter) {
        return new MainActivityViewModelFactory(menuAdapter);
    }


}