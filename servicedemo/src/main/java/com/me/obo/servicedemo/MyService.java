package com.me.obo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Toast.makeText(this,"this is Other",Toast.LENGTH_LONG).show();
        return myAidlInterface;
    }


    IMyAidlInterface.Stub myAidlInterface = new IMyAidlInterface.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int registerTestCall() throws RemoteException {
            return 1111;
        }

        @Override
        public String invokCallBack() throws RemoteException {
            return "123456";
        }
    };
}
