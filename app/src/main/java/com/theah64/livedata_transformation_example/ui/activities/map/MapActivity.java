package com.theah64.livedata_transformation_example.ui.activities.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.databinding.ActivityMapBinding;
import com.theah64.livedata_transformation_example.ui.activities.base.BaseAppCompatActivity;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;

public class MapActivity extends BaseAppCompatActivity {


    @Inject
    MapActivityViewModel viewModel;

    public static void start(Context context) {
        final Intent i = new Intent(context, MapActivity.class);
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
        ActivityMapBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_map
        );

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaggerMapActivityComponent.builder()
                .mapActivityModule(new MapActivityModule(this))
                .build()
                .inject(this);

        viewModel.getToastMessage().observe(this, data -> {
            Snackbar.make(binding.clMapTransformations, data, Snackbar.LENGTH_SHORT)
                    .show();
        });

        binding.setViewModel(viewModel);

    }
}
