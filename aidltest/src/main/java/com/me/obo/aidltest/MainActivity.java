package com.me.obo.aidltest;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.me.obo.servicedemo.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_ss).setOnClickListener(this);
        bindService(new Intent("com.me.obo.servicedemo.action.MyService"), serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    IMyAidlInterface iMyAidlInterface;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    public void onClick(View v) {
        try {
            String aaa = iMyAidlInterface.invokCallBack();
            System.out.print(aaa);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
