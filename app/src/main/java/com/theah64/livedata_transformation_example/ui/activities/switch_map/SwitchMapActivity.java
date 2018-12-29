package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.databinding.ActivitySwitchMapBinding;
import com.theah64.livedata_transformation_example.di.base.ActivityModule;
import com.theah64.livedata_transformation_example.ui.adapters.recyclerview_adapters.UsersAdapter;
import com.theah64.livedata_transformation_example.util.App;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SwitchMapActivity extends AppCompatActivity {

    @Inject
    SwitchMapViewModel viewModel;

    public static void start(Context context) {
        final Intent i = new Intent(context, SwitchMapActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySwitchMapBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_switch_map
        );

        ((App) getApplicationContext())
                .getApplicationComponent()
                .switchMapBuilder()
                .activityModule(new ActivityModule(this))
                .switchMapTransformationActivityModule(new SwitchMapActivityModule())
                .build()
                .inject(this);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        UsersAdapter adapter = new UsersAdapter(SwitchMapActivity.this);
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
