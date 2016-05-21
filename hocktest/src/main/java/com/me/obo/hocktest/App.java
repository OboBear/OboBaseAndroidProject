package com.me.obo.hocktest;

import android.app.Application;
import android.util.Log;

/**
 * Created by obo on 16/5/20.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class App extends Application {

    private String a = "123";

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void printA() {
        Log.i("App","a="+a);
    }
}
