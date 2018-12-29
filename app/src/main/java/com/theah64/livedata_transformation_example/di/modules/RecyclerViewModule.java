package com.theah64.livedata_transformation_example.di.modules;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;

import com.theah64.livedata_transformation_example.R;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import dagger.Module;
import dagger.Provides;

@Module
public class RecyclerViewModule {

    @Provides
    DividerItemDecoration provideDividerItemDecoration(Context context, GradientDrawable gd) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(gd);
        return dividerItemDecoration;
    }

    @Provides
    GradientDrawable provideGradientDrawable(Context context) {
        // Creating shape
        final GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setSize(1, 1);
        gd.setColor(ContextCompat.getColor(context, R.color.grey_50));
        return gd;
    }
}
