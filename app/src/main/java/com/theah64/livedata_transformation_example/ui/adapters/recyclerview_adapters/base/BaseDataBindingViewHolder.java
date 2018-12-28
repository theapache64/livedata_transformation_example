package com.theah64.livedata_transformation_example.ui.adapters.recyclerview_adapters.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseDataBindingViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private final B binding;

    public BaseDataBindingViewHolder(B binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public B getBinding() {
        return binding;
    }
}
