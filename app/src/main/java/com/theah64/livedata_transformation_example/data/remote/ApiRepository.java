package com.theah64.livedata_transformation_example.data.remote;

import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {

    private final ApiInterface apiInterface;

    @Inject
    public ApiRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public LiveData<SearchResponse> getSearch(String query) {

        final MutableLiveData<SearchResponse> ldSearchResponse = new MutableLiveData<>();

        apiInterface.search(query).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                ldSearchResponse.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                ldSearchResponse.setValue(null);
            }
        });

        return ldSearchResponse;
    }
}
