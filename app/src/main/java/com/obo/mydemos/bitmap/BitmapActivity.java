package com.obo.mydemos.bitmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class BitmapActivity extends BaseActivity {
    public final static String ACTION = "com.obo.activity.intent.action.BitmapActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
    }

    @Override
    protected void onClick(View sender) {

    }

}
