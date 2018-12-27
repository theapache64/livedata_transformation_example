package com.theah64.livedata_transformation_example.ui.activities.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.ui.activities.base.BaseAppCompatActivity;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends BaseAppCompatActivity {

    public static void start(Context context) {
        final Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






    }

}
