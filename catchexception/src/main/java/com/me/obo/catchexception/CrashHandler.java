package com.me.obo.catchexception;

import android.content.Context;
import android.util.Log;

/**
 * Created by obo on 2017/3/20.
 * Email:obo.lin@dingtone.me
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static class CrashHandlerHolder {
        private static CrashHandler instance = new CrashHandler();
    }

    public static CrashHandler getInstance() {
        return CrashHandlerHolder.instance;
    }

    public CrashHandler() {
        Log.i("","");
    }

    public void handleCrash() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i("", "");
//        TraceLog.printCallStatck(e);
    }
}
