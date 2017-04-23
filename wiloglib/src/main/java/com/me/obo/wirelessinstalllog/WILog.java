package com.me.obo.wirelessinstalllog;

import android.util.Log;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class WILog {

    public static void i(String TAG, String msg) {
        Log.i(TAG, msg);
    }

    public static void d(String TAG, String msg) {
        Log.d(TAG, msg);
    }
    public static void w(String TAG, String msg) {
        Log.w(TAG, msg);
    }
    public static void e(String TAG, String msg) {
        Log.e(TAG, msg);
    }


}
