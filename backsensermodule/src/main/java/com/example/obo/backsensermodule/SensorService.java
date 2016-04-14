package com.example.obo.backsensermodule;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

/**
 * Created by obo on 16/3/19.
 * Email:obo1993@gmail.com
 */
public class SensorService extends Service {

    public static final String TAG = SensorService.class.getCanonicalName();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor>accelerometerList =  sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(sensorEventListener,accelerometerList.get(0),10);

        return null;
    }

    SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            Log.i(TAG,"onSensorChanged:"+event.values[0]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


}
