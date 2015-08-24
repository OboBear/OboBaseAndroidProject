package com.obo.mydemos.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class OBService extends Service {
    public OBService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

}
