package com.obo.utils.network;

import android.util.Log;

/**
 * Created by obo on 15/10/21.
 */
public class LogUtil {
    public static void i(Object object,String message)
    {
        Log.i(object.getClass().getCanonicalName(),message);
    }


    public static void d(Object object,String message)
    {
        Log.d(object.getClass().getCanonicalName(),message);
    }

    public static void e(Object object,String message)
    {
        Log.e(object.getClass().getCanonicalName(),message);
    }

    public static void v(Object object,String message)
    {
        Log.v(object.getClass().getCanonicalName(),message);
    }

    public static void w(Object object,String message)
    {
        Log.w(object.getClass().getCanonicalName(),message);
    }
}
