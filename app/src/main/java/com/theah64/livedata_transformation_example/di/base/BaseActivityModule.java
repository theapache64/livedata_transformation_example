package com.theah64.livedata_transformation_example.di.base;

import androidx.fragment.app.FragmentActivity;

public abstract class BaseActivityModule<T> {

    private final FragmentActivity fragmentActivity;

    public BaseActivityModule(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    protected FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }

    protected abstract T getViewModel();
}
