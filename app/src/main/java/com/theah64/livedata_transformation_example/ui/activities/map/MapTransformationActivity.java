package com.theah64.livedata_transformation_example.ui.activities.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMapTransformationBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_map_transformation
        );

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaggerMapTransformationActivityComponent.builder()
                .mapTransformationActivityModule(new MapTransformationActivityModule(this))
                .build()
                .inject(this);

        viewModel.getToastMessage().observe(this, data -> {
            Snackbar.make(binding.clMapTransformations, data, Snackbar.LENGTH_SHORT)
                    .show();
        });

        binding.setViewModel(viewModel);

    }
}
