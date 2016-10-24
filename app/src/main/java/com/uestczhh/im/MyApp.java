package com.uestczhh.im;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by zhanghao on 2016/10/24.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
