package com.theah64.livedata_transformation_example.ui.adapters.binding_adapters;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

public class ImageViewBindingAdapter {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);

        /*GlideApp.with(imageView.getContext())
                .load(url)
                .into(imageView);*/
    }

}
