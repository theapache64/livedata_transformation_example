package com.theah64.livedata_transformation_example.ui.activities.map;

import android.graphics.Color;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.util.System;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MapTransformationViewModel extends ViewModel {


    private static final int[] colors = new int[]{
            R.color.red_500,
            R.color.green_500,
            R.color.blue_500,
    };


    private final MutableLiveData<Integer> index = new MutableLiveData<>();
    public final ObservableInt backgroundColor = new ObservableInt(Color.GREEN);


    public MapTransformationViewModel() {
        backgroundColor.set(Color.YELLOW);
    }

    public void changeBackgroundColor() {
        System.out.println("Changing index value");
        backgroundColor.set(Color.BLUE);
    }
}
