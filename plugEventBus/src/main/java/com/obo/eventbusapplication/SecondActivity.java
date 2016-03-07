package com.obo.eventbusapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import de.greenrobot.event.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {

//        switch (v.getId()) {
//            case R.id.button:
//                EventBus.getDefault().post(editText.getText().toString());
//                break;
//        }

        EventBus.getDefault().post(editText.getText().toString());

    }
}
