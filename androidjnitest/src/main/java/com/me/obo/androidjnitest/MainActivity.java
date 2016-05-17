package com.me.obo.androidjnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("ndkActivity");
    }

    public native int getInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = getInt();
        Log.i("","i"+i);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText("i="+i);
    }
}
