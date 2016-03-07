package com.obo.mydemos.view.singletouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.obo.activity.R;

public class SingleTouchActivity extends AppCompatActivity {

    public static String ACTION = "com.obo.activity.intent.action.SingleTouchActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_touch);
    }

}
