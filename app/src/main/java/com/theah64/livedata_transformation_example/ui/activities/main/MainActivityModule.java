package com.theah64.livedata_transformation_example.ui.activities.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.di.base.BaseActivityModule;
import com.theah64.livedata_transformation_example.models.MenuItem;
import com.theah64.livedata_transformation_example.ui.adapters.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import dagger.Module;
import dagger.Provides;

@Module
class MainActivityModule extends BaseActivityModule {

    private final MenuAdapter.Callback menuAdapterCallback;

    MainActivityModule(FragmentActivity fragmentActivity, MenuAdapter.Callback menuAdapterCallback) {
        super(fragmentActivity);
        this.menuAdapterCallback = menuAdapterCallback;
    }

    @Provides
    MainActivityViewModel provideMainActivityViewModel(MainActivityViewModelFactory factory) {
        return ViewModelProviders.of(getFragmentActivity(), factory)
                .get(MainActivityViewModel.class);
    }

    @Provides
    Context provideContext() {
        return getFragmentActivity();
    }

    @Provides
    MenuAdapter.Callback provideMenuAdapterCallback() {
        return menuAdapterCallback;
    }

    @Provides
    MainActivityViewModelFactory provideViewModelFactory(MenuAdapter menuAdapter) {
        return new MainActivityViewModelFactory(menuAdapter);
    }

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