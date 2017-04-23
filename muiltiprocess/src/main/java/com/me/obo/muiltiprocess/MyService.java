package com.me.obo.muiltiprocess;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by obo on 16/8/9.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class MyService extends Service {
    private static final String TAG = MyService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Application application = getApplication();

        Log.i(TAG,"MyService onCreate");


        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);

        View view = LayoutInflater.from(this).inflate(R.layout.widget_button,null);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();

        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

        // 设置期望的bitmap格式

        layoutParams.format = PixelFormat.TRANSLUCENT;

        // 以下属性在Layout Params中常见重力、坐标，宽高
        layoutParams.gravity = Gravity.LEFT | Gravity. TOP;
        layoutParams.x = 100;
        layoutParams.y = 100;

        layoutParams .width = WindowManager.LayoutParams. WRAP_CONTENT;
        layoutParams .height = WindowManager.LayoutParams. WRAP_CONTENT;

        windowManager.addView(view,layoutParams);

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(TAG,"onRebind");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
