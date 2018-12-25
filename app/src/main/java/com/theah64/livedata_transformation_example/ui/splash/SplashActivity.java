package com.theah64.livedata_transformation_example.ui.splash;

import android.os.Bundle;
import android.widget.Toast;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.data.remote.RemoteInterface;
import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;
import com.theah64.livedata_transformation_example.util.App;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    @Inject
    RemoteInterface remoteInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        App.getApplicationComponent().inject(this);

        remoteInterface.search("Shifar").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                Toast.makeText(SplashActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });

    }
}
