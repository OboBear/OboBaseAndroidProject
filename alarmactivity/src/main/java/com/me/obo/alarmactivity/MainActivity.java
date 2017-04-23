package com.me.obo.alarmactivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.set_alarm).setOnClickListener(this);
        findViewById(R.id.cancel_alarm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.set_alarm) {

            Intent intent = new Intent("cn.pocketdigi.update.alarm");
            intent.setClass(this, AlarmReceiver.class);

            PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            //设置一个PendingIntent对象，发送广播
            AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
            //获取AlarmManager对象
            // am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+3500, pi);//只执行一次

            // am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+3500, 10000, pi); //重复执行
//            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 9000, pi);

            am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000,3000, pi);

        } else {

            Intent intent = new Intent("cn.pocketdigi.update.alarm");
            intent.setClass(this, AlarmReceiver.class);

            PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
            //设置一个PendingIntent对象，发送广播
            AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
            //获取AlarmManager对象
            // am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+3500, pi);//只执行一次
            am.cancel(pi);
        }
    }
}
