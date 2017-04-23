package com.me.obo.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "TestApplication = " + TestApplication.a);
        TestApplication.a = 100;
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.me.obo.servicetest","com.me.obo.servicetest.TestService");
        intent.setComponent(componentName);
        startService(intent);
    }
}
