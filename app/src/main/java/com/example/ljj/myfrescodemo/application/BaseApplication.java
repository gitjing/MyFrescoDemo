package com.example.ljj.myfrescodemo.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * Created by ljj on 16/10/8.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        ButterKnife.setDebug(true);

    }
}
