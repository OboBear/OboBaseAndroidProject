package com.obo.eventbusapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String ACTION = "com.obo.eventbusapplication.action.EventBusActivity";

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        textView = (TextView) findViewById(R.id.textView);

        EventBus.getDefault().register(this);
    }

    public void onEvent(String event) {
        textView.setText(event);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//
//            case R.id.button2: {
//                Intent intent = new Intent(this,SecondActivity.class);
//                startActivity(intent);
//            }
//
//                break;
//        }

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
