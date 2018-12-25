package com.theah64.livedata_transformation_example.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.data.remote.RemoteInterface;
import com.theah64.livedata_transformation_example.data.remote.RemoteRepository;
import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.di.modules.NetworkModule;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }
}
