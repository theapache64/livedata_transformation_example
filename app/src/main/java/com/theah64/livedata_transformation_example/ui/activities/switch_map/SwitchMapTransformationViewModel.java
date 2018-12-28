package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import com.theah64.livedata_transformation_example.data.remote.ApiRepository;
import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.util.System;

import javax.inject.Inject;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class SwitchMapTransformationViewModel extends ViewModel {

    // instance vars
    private ApiRepository apiRepository;

    @Inject
    public SwitchMapTransformationViewModel(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public final MutableLiveData<String> searchQuery = new MutableLiveData<>();

    private LiveData<SearchResponse> searchResponse = Transformations.switchMap(searchQuery, new Function<String, LiveData<SearchResponse>>() {
        @Override
        public LiveData<SearchResponse> apply(String input) {
            System.out.println("Requesting API for input :" + input);
            return apiRepository.getSearch(input);
        }
    });

    public LiveData<SearchResponse> getSearchResponse() {
        return searchResponse;
    }
}
