package com.chanchuan.demo;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author : Chanchuan
 * Date       : 2020/12/3/003    上午 11:36
 */
public class MyApplication extends Application {
    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Fresco.initialize(this);
    }
}
