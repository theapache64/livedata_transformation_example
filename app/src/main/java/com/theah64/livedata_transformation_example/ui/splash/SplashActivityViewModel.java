package com.theah64.livedata_transformation_example.ui.splash;

import android.annotation.SuppressLint;

import com.theah64.livedata_transformation_example.util.SingleLiveEvent;
import com.theah64.livedata_transformation_example.util.System;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

class SplashActivityViewModel extends ViewModel {

    private static final long SPLASH_DURATION = 1500;
    private final MutableLiveData<Boolean> navigation = new MutableLiveData<>();

    @SuppressLint("CheckResult")
    void start() {

        Observable.just(1, 2, 3, 4, 5)
                .zipWith(Observable.interval(1000, TimeUnit.MILLISECONDS), (item, interval) -> item)
                .subscribe(ignore -> {
                    System.out.println("Hitting..!!" + ignore);
                    navigation.postValue(true);
                });


        /*Observable.empty()
                .delay(SPLASH_DURATION, TimeUnit.MILLISECONDS)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        navigation.setValue(true);
                    }
                })
                .subscribe();*/
    }

    MutableLiveData<Boolean> getNavigation() {
        return navigation;
    }
}
