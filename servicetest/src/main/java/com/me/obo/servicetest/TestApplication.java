package com.me.obo.servicetest;

import android.app.Application;
import android.util.Log;

/**
 * Created by obo on 2017/4/13.
 * Email:obo.lin@dingtone.me
 */

public class TestApplication extends Application {
    public static int a = 1;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TestApplication","TestApplication onCreate");
    }
}
