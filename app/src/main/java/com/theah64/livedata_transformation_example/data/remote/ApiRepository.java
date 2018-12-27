package com.theah64.livedata_transformation_example.data.remote;

import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ApiRepository {

    private final ApiInterface apiInterface;

    @Inject
    public ApiRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public LiveData<SearchResponse> getSearch(String query) {
        final MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();
        return searchResponse;
    }
}
