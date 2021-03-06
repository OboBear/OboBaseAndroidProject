package com.obo.mydemos.singleTop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;
import com.obo.utils.network.LogUtil;

import java.util.ArrayList;

public class JumpToMainActivity extends BaseActivity {
    public static String ACTION = "com.obo.activity.intent.action.JumpToMainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_to_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        initData();
    }

    private void initData()
    {
        Intent intent = getIntent();
        ArrayList<ArrayList<CustomClass>>data = (ArrayList<ArrayList<CustomClass>>) intent.getSerializableExtra("data");

        ArrayList<CustomClass>d1 = data.get(0);
        System.out.println("received:" + d1.get(0).result);

    }

    @Override
    public void onClick(View sender) {
        finish();
    }

}
