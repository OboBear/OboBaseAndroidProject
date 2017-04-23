package com.me.obo.timeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        long timeStamp = System.currentTimeMillis();

        System.out.println("123");

    }
}
