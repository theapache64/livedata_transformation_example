package com.theah64.livedata_transformation_example.ui.activities.switch_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.theah64.livedata_transformation_example.R;

public class SwitchMapTransformationActivity extends AppCompatActivity {


    public static void start(Context context) {
        final Intent i = new Intent(context, SwitchMapTransformationActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_map_transformation);
    }
}
