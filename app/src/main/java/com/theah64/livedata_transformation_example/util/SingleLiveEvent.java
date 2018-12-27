package com.theah64.livedata_transformation_example.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class SingleLiveEvent extends MutableLiveData<Boolean> {
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super Boolean> observer) {
        super.observe(owner, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                observer.onChanged(aBoolean);
                removeObserver(this);
            }
        });
    }

    public void done() {
        setValue(true);
    }
}
