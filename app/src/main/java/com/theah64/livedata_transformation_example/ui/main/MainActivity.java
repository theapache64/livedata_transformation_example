package com.theah64.livedata_transformation_example.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.data.remote.RemoteInterface;
import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.ui.base.BaseAppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

public class MainActivity extends BaseAppCompatActivity {

    @Inject
    RemoteInterface remoteInterface;

    public static void start(Context context) {
        final Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AndroidInjection.inject(this);

        System.out.println("The thing is " + remoteInterface);
        remoteInterface.search("query").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                System.out.println(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });

    }

}
