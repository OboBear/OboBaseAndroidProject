package com.obo.mydemos.view.moutitouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.obo.activity.R;

public class MoutiTouchActivity extends AppCompatActivity {
    public static final String ACTION ="com.obo.activity.intent.action.MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouti_touch);
    }
}
