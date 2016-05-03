package com.me.obo.aidltest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.me.obo.servicedemo.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindService(new Intent("com.me.obo.servicedemo.action.MyService"),serviceConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Class thisclass = service.getClass();

            IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);

            try {
                String aaa = iMyAidlInterface.invokCallBack();
                int b= 8 ;
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            int a= 8 ;

//            IMyAidlInterface.Stub iMyAidlInterface = (IMyAidlInterface.Stub) service;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };
}
