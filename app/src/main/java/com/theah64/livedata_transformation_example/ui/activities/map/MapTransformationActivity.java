package com.theah64.livedata_transformation_example.ui.activities.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.databinding.ActivityMapTransformationBinding;
import com.theah64.livedata_transformation_example.ui.activities.base.BaseAppCompatActivity;
import com.theah64.livedata_transformation_example.util.System;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

public class MapTransformationActivity extends BaseAppCompatActivity {


    @Inject
    MapTransformationViewModel viewModel;

    public static void start(Context context) {
        final Intent i = new Intent(context, MapTransformationActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMapTransformationBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_map_transformation
        );

        DaggerMapTransformationActivityComponent.builder()
                .mapTransformationActivityModule(new MapTransformationActivityModule(this))
                .build()
                .inject(this);

        viewModel.getToastMessage().observe(this, data -> {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        });

        binding.setViewModel(viewModel);

    }
}
