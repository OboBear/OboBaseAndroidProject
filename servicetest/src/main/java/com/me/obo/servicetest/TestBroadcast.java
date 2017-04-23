package com.me.obo.servicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by obo on 2017/4/13.
 * Email:obo.lin@dingtone.me
 */

public class TestBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int flags = intent.getFlags();
        Log.i("TestBroadcast", "TestApplication broadcast flags = " + flags);

    }
}
