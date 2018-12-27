package com.theah64.livedata_transformation_example.ui.activities.main;

import com.theah64.livedata_transformation_example.ui.adapters.MenuAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    private final MenuAdapter menuAdapter;

    MainActivityViewModelFactory(MenuAdapter menuAdapter) {
        this.menuAdapter = menuAdapter;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(menuAdapter);
    }
}
