package com.obo.mydemos.broadcast;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

import com.obo.utils.network.LogUtil;

public class BroadCastReceiverDemo extends BroadcastReceiver {
    public BroadCastReceiverDemo() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        LogUtil.i(this, "BroadCastReceiverDemo:::");
        Intent intent1 = new Intent(BroadCastActivity.ACTION);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent1);

        KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);

        KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("BroadCastActivity");

        keyguardLock.disableKeyguard();
    }
}
