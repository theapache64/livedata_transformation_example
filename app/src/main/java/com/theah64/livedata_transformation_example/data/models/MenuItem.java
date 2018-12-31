package com.theah64.livedata_transformation_example.data.models;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

public class MenuItem {

    @IdRes
    private final int id;

    @StringRes
    private final int title, desc;

    public MenuItem(int id, int title, int desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    @IdRes
    public int getId() {
        return id;
    }

    @StringRes
    public int getTitle() {
        return title;
    }

    @StringRes
    public int getDesc() {
        return desc;
    }
}
