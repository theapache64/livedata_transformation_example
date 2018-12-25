package com.theah64.livedata_transformation_example.data.remote;

import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RemoteRepository {

    public LiveData<SearchResponse> getSearch(String query) {
        final MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();
        return searchResponse;
    }
}
