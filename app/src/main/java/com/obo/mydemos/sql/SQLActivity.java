package com.obo.mydemos.sql;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.obo.activity.R;

public class SQLActivity extends AppCompatActivity {
    public final static String ACTION = "com.obo.mydemos.sql.intent.action.SQLActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

    }
}
