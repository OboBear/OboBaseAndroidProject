package com.me.obo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"this is Other",Toast.LENGTH_LONG).show();
        return myAidlInterface;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this,"this is Other",Toast.LENGTH_LONG).show();
        Log.i("MyService","MyService111 onStart");

        MyAsyncTast MyAsyncTast = new MyAsyncTast();
        MyAsyncTast.execute();

    }


    class MyAsyncTast extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }

    private final IMyAidlInterface.Stub myAidlInterface = new IMyAidlInterface.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int registerTestCall() throws RemoteException {
            return 1111;
        }

        @Override
        public String invokCallBack() throws RemoteException {

            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MyService.this,"jjjjj",Toast.LENGTH_LONG).show();
                }
            });
            return "123456";
        }
    };

    Handler handler = new Handler();

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyService","MyService111 onDestroy");
    }
}
