package com.obo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.obo.activity.R;
import com.obo.base.BaseActivity;

import java.io.Serializable;

public class ListViewActivity extends BaseActivity {

    public static void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,ListViewActivity.class);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity,Serializable extraData)
    {
        Intent intent = new Intent(activity,ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extraData",extraData);
        intent.putExtra("bundle", bundle);
        activity.startActivity(intent);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_list_view;
    }

    @Override
    protected void initContentView() {

    }


}
