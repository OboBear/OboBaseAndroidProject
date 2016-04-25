package com.me.obo.androiddexclassloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String dexPath;
        DexClassLoader dexClassLoader = new DexClassLoader(dexPath,);
    }
}
