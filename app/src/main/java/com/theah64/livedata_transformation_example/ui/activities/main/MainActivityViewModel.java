package com.theah64.livedata_transformation_example.ui.activities.main;

import com.theah64.livedata_transformation_example.ui.adapters.MenuAdapter;
import com.theah64.livedata_transformation_example.util.System;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private final MenuAdapter menuAdapter;

    @Inject
    public MainActivityViewModel(MenuAdapter menuAdapter) {
        this.menuAdapter = menuAdapter;
    }

    public MenuAdapter getAdapter() {
        return menuAdapter;
    }
}
