package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.databinding.ActivitySwitchMapTransformationBinding;
import com.theah64.livedata_transformation_example.util.System;

import javax.inject.Inject;

public class SwitchMapTransformationActivity extends AppCompatActivity {


    public static void start(Context context) {
        final Intent i = new Intent(context, SwitchMapTransformationActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySwitchMapTransformationBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_switch_map_transformation
        );

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final SwitchMapTransformationViewModel viewModel = ViewModelProviders.of(this)
                .get(SwitchMapTransformationViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
