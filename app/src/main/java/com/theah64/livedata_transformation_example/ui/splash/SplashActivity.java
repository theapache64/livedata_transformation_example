package com.theah64.livedata_transformation_example.ui.splash;

import android.os.Bundle;
import android.widget.Toast;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.util.System;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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
                Toast.makeText(SplashActivity.this, "Navigation is true, removing", Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.start();
    }


}
