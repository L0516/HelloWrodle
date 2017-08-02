package com.example.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
