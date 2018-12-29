package com.theah64.livedata_transformation_example.ui.activities.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.databinding.ActivityMainBinding;
import com.theah64.livedata_transformation_example.di.base.ActivityModule;
import com.theah64.livedata_transformation_example.models.MenuItem;
import com.theah64.livedata_transformation_example.ui.activities.base.BaseAppCompatActivity;
import com.theah64.livedata_transformation_example.ui.activities.map.MapActivity;
import com.theah64.livedata_transformation_example.ui.activities.switch_map.SwitchMapActivity;
import com.theah64.livedata_transformation_example.ui.adapters.recyclerview_adapters.MenuAdapter;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;

public class MainActivity extends BaseAppCompatActivity implements MenuAdapter.Callback {


    @Inject
    MainActivityViewModel viewModel;

    @Inject
    DividerItemDecoration divider;

    public static void start(Context context) {
        final Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaggerMainActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

        binding.include.rvMenu.addItemDecoration(divider);

        binding.setViewModel(viewModel);

    }

    @Override
    public void onItemClicked(MenuItem menuItem) {
        switch (menuItem.getId()) {

            case R.id.map:
                MapActivity.start(this);
                break;

            case R.id.switch_map:
                SwitchMapActivity.start(this);
                break;

            case R.id.custom_map:
                break;
        }
    }
}
