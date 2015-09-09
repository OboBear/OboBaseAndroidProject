package com.obo.mydemos.navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class NavigationActivity extends BaseActivity {

    public static String ACTION = "com.obo.activity.intent.action.NavigationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initContentView();
    }

    @Override
    protected void onClick(View sender) {

    }

    private void initContentView()
    {

    }

}
