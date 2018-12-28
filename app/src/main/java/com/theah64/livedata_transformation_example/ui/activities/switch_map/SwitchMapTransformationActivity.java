package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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
                .switchMapBuilder()
                .activityModule(new ActivityModule(this))
                .switchMapTransformationActivityModule(new SwitchMapTransformationActivityModule())
                .build()
                .inject(this);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        UsersAdapter adapter = new UsersAdapter(SwitchMapTransformationActivity.this);
        binding.rvSearchResult.setAdapter(
                adapter
        );

        viewModel.getSearchResponse().observe(
                this,
                searchResponse -> {
                    if (!searchResponse.isError()) {
                        adapter.setUsers(searchResponse.getData().getUsers());
                    } else {
                        Toast.makeText(this, searchResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
