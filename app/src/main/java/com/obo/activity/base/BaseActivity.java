package com.obo.activity.base;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

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
     * get runtime info
     *
     *
     */
    protected void showMemInfo()
    {
        long max = Runtime.getRuntime().maxMemory();

        long total = Runtime.getRuntime().totalMemory();

        long free = Runtime.getRuntime().freeMemory();

        long used = total - free;

        System.out.println("最大内存 = " + max);
        System.out.println("已分配内存 = " + total);
        System.out.println("已分配内存中剩余空间 = " + free);
        System.out.println("已用内存 = " + used);
        System.out.println("时间 = " + System.currentTimeMillis());
    }

    /**
     *
     * @return current Application
     */
    protected Application getApp()
    {
        return getApplication();
    }


    /**
     * install native apk
     * @param path the path ok apk
     */
    protected void installAPK(String path)
    {
        String fileName = Environment.getExternalStorageDirectory() + path;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    protected abstract void onClick(View sender);

}
