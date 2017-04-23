package com.me.obo.proxydelegateapplication;

import android.app.Application;

/**
 * Created by obo on 16/8/3.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public abstract class ProxyApplication extends Application {
    protected abstract void initProxyApplication();
}
