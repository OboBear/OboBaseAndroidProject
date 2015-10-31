package com.obo.mydemos.animate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.obo.activity.R;
import com.obo.arrtest.ArrTest;

public class AnimateActivity extends AppCompatActivity {
    public final static String ACTION = "com.obo.activity.intent.action.AnimateActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        System.gc();
        ArrTest t;
    }
}
