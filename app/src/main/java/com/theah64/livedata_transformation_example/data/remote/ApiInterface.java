package com.theah64.livedata_transformation_example.data.remote;

import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    /**
     * @param query <p></p>
     * @return SearchResponse
     */
    @FormUrlEncoded
    @POST("search")
    Call<SearchResponse> search(
            @Field("query") @NonNull String query
    );

}
