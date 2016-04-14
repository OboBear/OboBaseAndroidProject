package com.obo.plugrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import rx.Observable;


public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Observable.just("hello")
                .map(s -> s+"123")
                .map(s -> s+"sss")
                .subscribe(s -> System.out.print(s));

    }

}
