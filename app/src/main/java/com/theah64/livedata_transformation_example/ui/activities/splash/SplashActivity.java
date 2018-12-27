package com.theah64.livedata_transformation_example.ui.activities.splash;

import android.os.Bundle;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.ui.activities.main.MainActivity;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class SplashActivity extends AppCompatActivity {

    @Inject
    SplashActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DaggerSplashActivityComponent.builder()
                .splashActivityModule(new SplashActivityModule(this))
                .build()
                .inject(this);

        // observing for navigation
        viewModel.getTimerEvent().observe(this, ignore -> {
            // timer finished
            MainActivity.start(SplashActivity.this);
            finish();
        });

        viewModel.startTimer();
    }


}
