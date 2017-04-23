package com.me.obo.getapppackages;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by obo on 16/8/26.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String packageName = intent.getDataString();
            Log.i("","安装了：" + packageName);
        }
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")){
            String packageName = intent.getDataString();
            Log.i("","卸载了：" + packageName);
        }
    }
}
