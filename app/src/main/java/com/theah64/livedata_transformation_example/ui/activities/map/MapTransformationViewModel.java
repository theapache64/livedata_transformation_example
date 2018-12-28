package com.theah64.livedata_transformation_example.ui.activities.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MapTransformationViewModel extends ViewModel {

    public String name;
    private MutableLiveData<String> user = new MutableLiveData<>();
    private LiveData<String> toastMessage = Transformations.map(user, input ->
            input.isEmpty() ? "Please enter your name " : "User added : " + input
    );

    public void onAddUserClicked(String name) {
        user.setValue(name);
    }

    LiveData<String> getToastMessage() {
        return toastMessage;
    }
}
