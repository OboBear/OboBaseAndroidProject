package com.obo.mydemos.view.matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.obo.activity.R;

public class MatrixActivity extends AppCompatActivity {
    public final static String ACTION = "com.obo.activity.intent.action.MatrixActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);


    }

}
