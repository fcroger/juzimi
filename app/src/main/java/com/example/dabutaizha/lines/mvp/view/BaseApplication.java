package com.example.dabutaizha.lines.mvp.view;

import android.app.Application;
import android.content.Context;

import com.example.dabutaizha.lines.ResUtil;
import com.example.dabutaizha.lines.bean.model.MyObjectBox;
import com.facebook.stetho.Stetho;

import io.objectbox.BoxStore;

public class BaseApplication extends Application {
    public static final String TAG = BaseApplication.class.getSimpleName();

    private static Context mInstance;

    private BoxStore mBoxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        mBoxStore = MyObjectBox.builder().androidContext(mInstance).build();
        //初始化stetho
        Stetho.initializeWithDefaults(this);
        ResUtil.init();
    }
    public static Context getInstance() {
        return mInstance;
    }

    public BoxStore getBoxStore() {
        return mBoxStore;
    }
}
