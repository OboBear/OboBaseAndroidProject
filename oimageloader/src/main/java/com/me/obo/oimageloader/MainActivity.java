package com.me.obo.oimageloader;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import junit.framework.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Executors.newCachedThreadPool();
        try {
//            InputStream inputStream = getResources().getAssets().open("file:///android_asset/sd.cpp");
//            InputStream inputStream = getResources().getAssets().open("sd.cpp");
            URL url = new URL("file:///android_asset/sd.cpp");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();


//            File file = new File("file:///android_asset/sd.cpp");
//            FileInputStream inputStream = new FileInputStream(file);
            byte[]inputString = new byte[inputStream.available()];
            inputStream.read(inputString);
            String ss = new String(inputString);
            Log.i("","");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void download(String imageUrl) {

    }
}
