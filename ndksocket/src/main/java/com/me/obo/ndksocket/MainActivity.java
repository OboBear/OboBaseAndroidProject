package com.me.obo.ndksocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    static {
        System.loadLibrary("hello");
    }
    public native int aTest();
    public native String assd(String hello);
//    public native int[] sortArray(int[] a);

    public native List<User> getUserList();
    public native User getUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String he = assd("11");
        Log.i("","");


        int[] array = new int[] {6,312,7,2};

        List<User>u = getUserList();
//        Log.i("","");

        User user = getUser();
        Log.i("","");


    }
}
