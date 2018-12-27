package com.theah64.livedata_transformation_example.models;

import androidx.annotation.StringRes;

public class MenuItem {

    @StringRes
    private final int title, desc;

    public MenuItem(int title, int desc) {
        this.title = title;
        this.desc = desc;
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
