package com.theah64.livedata_transformation_example.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theah64.livedata_transformation_example.R;
import com.theah64.livedata_transformation_example.databinding.MenuItemsRowBinding;
import com.theah64.livedata_transformation_example.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private static final List<MenuItem> MENU_ITEMS = new ArrayList<>();

    static {
        MENU_ITEMS.add(new MenuItem(R.id.map, R.string.map_title, R.string.map_desc));
        MENU_ITEMS.add(new MenuItem(R.id.switch_map, R.string.switch_map_title, R.string.switch_map_desc));
        MENU_ITEMS.add(new MenuItem(R.id.custom_map, R.string.custom, R.string.custom_desc));
    }

    private final Callback callback;

    @Inject
    MenuAdapter(Context context, Callback callback) {
        this.callback = callback;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final MenuItemsRowBinding binding = MenuItemsRowBinding.inflate(
                layoutInflater,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBinding().setMenuItem(
                MENU_ITEMS.get(position)
        );
    }

    @Override
    public int getItemCount() {
        return MENU_ITEMS.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final MenuItemsRowBinding binding;

        ViewHolder(MenuItemsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MenuItem menuItem = MENU_ITEMS.get(getLayoutPosition());
                    callback.onItemClicked(menuItem);
                }
            });
        }

        MenuItemsRowBinding getBinding() {
            return binding;
        }
    }

    public interface Callback {
        void onItemClicked(MenuItem menuItem);
    }
}
