package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import com.theah64.livedata_transformation_example.util.System;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class SwitchMapTransformationViewModel extends ViewModel {

    public final MutableLiveData<String> searchQuery = new MutableLiveData<>();

    private LiveData<String> searchResponse = Transformations.switchMap(searchQuery, new Function<String, LiveData<String>>() {
        @Override
        public LiveData<String> apply(String input) {
            System.out.println("Search input is " + input);
            return new MutableLiveData<>("Input : " + input);
        }
    });

    public LiveData<String> getSearchResponse() {
        return searchResponse;
    }
}
