package com.obo.activity.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    public  static String TAG = BaseActivity.class.getCanonicalName();

    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = this;
    }

    /**
     * replace findViewById
     *
     * @param ViewId the id of view
     */
    public <T> T $(int ViewId)
    {
        return (T) findViewById(ViewId);
    }

    /**
     *
     * @return current Application
     */
    protected Application getApp()
    {
        return getApplication();
    }

    protected abstract void onClick(View sender);
}
