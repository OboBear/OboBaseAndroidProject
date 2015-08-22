package com.obo.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public  static String TAG = BaseActivity.class.getCanonicalName();

    public Activity activity;

    protected abstract int setContentViewId();
    protected abstract void initContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
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

}
