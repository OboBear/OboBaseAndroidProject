package com.obo.mydemos.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class ServiceActivity extends BaseActivity implements ServiceConnection {

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        intent = new Intent(this,OBService.class);
        initContentView();
    }


    protected void initContentView() {

    }


    @Override
    protected void onClick(View sender) {
        switch (sender.getId())
        {
            case R.id.button2:
                startService(intent);
                break;
            case R.id.button3:
                stopService(intent);
                break;
            case R.id.button4:
                bindService(intent,this,BIND_AUTO_CREATE);
                break;
            case R.id.button5:
                unbindService(this);
                break;

            default:
        }
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
