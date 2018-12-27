package com.theah64.livedata_transformation_example.ui.splash;

import android.annotation.SuppressLint;

import com.theah64.livedata_transformation_example.util.System;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

class SplashActivityViewModel extends ViewModel {

    private static final long SPLASH_DURATION = 1500;


    @SuppressLint("CheckResult")
    void start() {

        Observable.just(1, 2, 3, 4, 5)
                .zipWith(Observable.interval(1000, TimeUnit.MILLISECONDS), (item, interval) -> item)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ignore -> {
                    System.out.println("Hitting..!!" + ignore);
                    navigation.call();
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

    SingleLiveEvent<Boolean> getNavigation() {
        return navigation;
    }
}
