package com.me.obo.catchexception;

import android.app.Application;

/**
 * Created by obo on 2017/3/20.
 * Email:obo.lin@dingtone.me
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().handleCrash();
    }
}
