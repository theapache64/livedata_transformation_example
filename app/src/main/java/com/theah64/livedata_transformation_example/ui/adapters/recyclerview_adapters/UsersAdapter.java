package com.theah64.livedata_transformation_example.ui.adapters.recyclerview_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.theah64.livedata_transformation_example.data.remote.models.SearchResponse;
import com.theah64.livedata_transformation_example.databinding.UsersRowBinding;
import com.theah64.livedata_transformation_example.ui.adapters.recyclerview_adapters.base.BaseDataBindingViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<SearchResponse.User> users = new ArrayList<>();
    private final LayoutInflater layoutInflater;

    public UsersAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setUsers(List<SearchResponse.User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                UsersRowBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBinding().setUser(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends BaseDataBindingViewHolder<UsersRowBinding> {
        ViewHolder(UsersRowBinding binding) {
            super(binding);
        }
    }

}
