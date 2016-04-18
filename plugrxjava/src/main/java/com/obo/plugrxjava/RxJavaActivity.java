package com.obo.plugrxjava;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import rx.Observable;


public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Observable.just("hello")
                .map(s -> printSSS(s+"123"))
                .map(s -> s+"sss")
                .subscribe(s -> Log.i("thisis",s));
    }

    public String printSSS(String s) {
        Log.i("thisis",""+s+(Looper.myLooper() == Looper.getMainLooper()));

        return "9888";
    }

}
