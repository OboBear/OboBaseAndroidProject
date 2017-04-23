package com.me.obo.alarmactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by obo on 2016/10/25.
 * Email:obo.lin@dingtone.me
 */

public class AlarmReceiver extends BroadcastReceiver{
    private static final String TAG = "AlarmReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.i(TAG, "收到广播");
//      Intent it=new Intent(context,AlarmActivity.class);
//      it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//      context.startActivity(it);
        //收到广播后启动Activity,简单起见，直接就跳到了设置alarm的Activity
        //intent必须加上Intent.FLAG_ACTIVITY_NEW_TASK flag
    }
}
