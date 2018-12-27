package com.theah64.livedata_transformation_example.ui.activities.splash;

import com.theah64.livedata_transformation_example.util.SingleLiveEvent;
import com.theah64.livedata_transformation_example.util.System;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.ViewModel;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

class SplashActivityViewModel extends ViewModel {

    private static final long SPLASH_DURATION = 1500;
    private final SingleLiveEvent timerEvent = new SingleLiveEvent();

    void startTimer() {

        Completable.complete()
                .delay(SPLASH_DURATION, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> {
                    System.out.println("Timer done");
                    timerEvent.done();
                })
                .subscribe();


    }

    SingleLiveEvent getTimerEvent() {
        return timerEvent;
    }
}
