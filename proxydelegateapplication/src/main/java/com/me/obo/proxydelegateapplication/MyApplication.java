package com.me.obo.proxydelegateapplication;

import android.app.Application;
import android.util.Log;

/**
 * Created by obo on 16/8/3.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class MyApplication extends Application {
    private final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG , " onCreate " + this.getApplicationContext().getClass().getSimpleName());
    }
}
