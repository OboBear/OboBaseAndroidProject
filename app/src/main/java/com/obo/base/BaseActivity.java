package com.obo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.Objects;

public class BaseActivity extends AppCompatActivity {

    public  static String TAG = BaseActivity.class.getCanonicalName();

    public Activity activity;

    public static void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,BaseActivity.class.getComponentType());
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity,Serializable extraData)
    {
        Intent intent = new Intent(activity,BaseActivity.class.getComponentType());
        Bundle bundle = new Bundle();
        bundle.putSerializable("extraData",extraData);
        intent.putExtra("bundle", bundle);
        activity.startActivity(intent);
    }

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

}
