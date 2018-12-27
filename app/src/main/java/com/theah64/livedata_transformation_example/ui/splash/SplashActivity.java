package com.theah64.livedata_transformation_example.ui.splash;

import android.os.Bundle;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.ui.main.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SplashActivityViewModel viewModel = ViewModelProviders.of(this)
                .get(SplashActivityViewModel.class);

        // observing for navigation
        viewModel.getTimerEvent().observe(this, ignore -> {
            // timer finished
            MainActivity.start(SplashActivity.this);
            finish();
        });

        viewModel.startTimer();
    }


}
