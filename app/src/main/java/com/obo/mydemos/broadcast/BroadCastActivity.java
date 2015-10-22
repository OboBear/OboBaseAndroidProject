package com.obo.mydemos.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class BroadCastActivity extends BaseActivity {
    public static String ACTION = "com.obo.activity.intent.action.BroadCastActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);//覆盖在屏幕锁之上。
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        if (!pm.isScreenOn()) {//屏幕时候保持高亮
            win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR);
        }

        setContentView(R.layout.activity_broad_cast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        this.registerReceiver(new BroadCastReceiverDemo(),intentFilter);
    }

    @Override
    public void onClick(View sender) {
        Snackbar.make(sender, "233333", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        sendBroadcast(new Intent("com.obo.mydemos.broadcast.BroadCastReceiverDemo"));

    }


}
