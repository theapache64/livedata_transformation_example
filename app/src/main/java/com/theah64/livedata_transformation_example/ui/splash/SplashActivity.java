package com.theah64.livedata_transformation_example.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.data.remote.RemoteInterface;
import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.di.components.DaggerApplicationComponent;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;
import com.theah64.livedata_transformation_example.ui.main.MainActivity;
import com.theah64.livedata_transformation_example.util.App;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SplashActivityViewModel viewModel = ViewModelProviders.of(this)
                .get(SplashActivityViewModel.class);

        // observing for navigation
        viewModel.getNavigation().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                System.out.println("Hit!!!");
                if (aBoolean) {
                    viewModel.getNavigation().removeObservers(SplashActivity.this);
                }
            }
        });

        viewModel.start();
    }


}
