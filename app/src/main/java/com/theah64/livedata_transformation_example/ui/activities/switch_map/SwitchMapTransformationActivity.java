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
import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.databinding.ActivitySwitchMapTransformationBinding;
import com.theah64.livedata_transformation_example.di.base.ActivityModule;
import com.theah64.livedata_transformation_example.ui.adapters.recyclerview_adapters.UsersAdapter;
import com.theah64.livedata_transformation_example.util.App;
import com.theah64.livedata_transformation_example.util.System;

import javax.inject.Inject;

public class SwitchMapTransformationActivity extends AppCompatActivity {

    @Inject
    SwitchMapTransformationViewModel viewModel;

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

        ((App) getApplicationContext())
                .getApplicationComponent()
                .plus(new SwitchMapTransformationActivityModule(this))
                .inject(this);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        viewModel.getSearchResponse().observe(
                this,
                searchResponse -> {
                    binding.rvSearchResult.setAdapter(
                            new UsersAdapter(SwitchMapTransformationActivity.this, searchResponse.getData().getUsers())
                    );
                }
        );

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
