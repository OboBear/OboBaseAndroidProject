package com.me.obo.foreveralive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by obo on 16/4/27.
 * Email:obo1993@gmail.com
 */
public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyBroadCast","MyBroadCast onReceive");
    }
}
