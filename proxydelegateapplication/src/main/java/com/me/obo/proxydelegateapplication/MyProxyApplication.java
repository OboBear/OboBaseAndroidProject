package com.me.obo.proxydelegateapplication;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by obo on 16/8/3.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class MyProxyApplication extends ProxyApplication {
    private final String TAG = MyProxyApplication.class.getSimpleName();
    private Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.i(TAG , "attachBaseContext");
        mContext = base;
        this.initProxyApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG , " onCreate" + this.getApplicationContext().getClass().getSimpleName());
//        BootLoader.boot(mContext);
    }

    @Override
    protected void initProxyApplication() {
//        BootLoader.resetClassLoader(mContext);

        String className = "android.app.Application";
        String key = "DELEGATE_APPLICATION_CLASS_NAME";
        ApplicationInfo appInfo = null;
        try {
            appInfo = getPackageManager().getApplicationInfo(super.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Bundle bundle = appInfo.metaData;
        if (bundle != null && bundle.containsKey(key)) {
            className = bundle.getString(key);
            if (className.startsWith("."))
            className = super.getPackageName() + className;
        }

        Class delegateClass = null;
        try {
            delegateClass = Class.forName(className, true, getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Application delegate = null;
        try {
            delegate = (Application) delegateClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            replaceAllApplication(delegate);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        delegateApplicationCreate(delegate);


    }

    private void replaceAllApplication(Application application) throws NoSuchFieldException, IllegalAccessException {
        Class baseContextClass = mContext.getClass();

        Field mOuterContext = baseContextClass.getDeclaredField("mOuterContext");
        mOuterContext.setAccessible(true);
        mOuterContext.set(mContext,application);

        Field mPackageInfoField = baseContextClass.getDeclaredField("mPackageInfo");
        mPackageInfoField.setAccessible(true);
        Object mPackageInfo = mPackageInfoField.get(mContext);


        Field mApplication =  mPackageInfo.getClass().getDeclaredField("mApplication");
        mApplication.setAccessible(true);
        mApplication.set(mPackageInfo,application);


        Field mActivityThreadField = mPackageInfo.getClass().getDeclaredField("mActivityThread");
        mActivityThreadField.setAccessible(true);
        Object mActivityThread =  mActivityThreadField.get(mPackageInfo);

        Field mInitialApplicationField = mActivityThread.getClass().getDeclaredField("mInitialApplication");
        mInitialApplicationField.setAccessible(true);
        mInitialApplicationField.set(mActivityThread,application);

        Field mAllApplicationsField = mActivityThread.getClass().getDeclaredField("mAllApplications");
        mAllApplicationsField.setAccessible(true);
        ArrayList<Application>mAllApplications = (ArrayList<Application>) mAllApplicationsField.get(mActivityThread);

        if (mAllApplications != null) {
            for (int i=0;i<mAllApplications.size();i++) {
                if (mAllApplications.get(i) == this) {
                    mAllApplications.remove(i);
                    mAllApplications.add(i,application);
                }
            }
        }

    }

    private void delegateApplicationCreate(Application delegate) {
        Method attach = null;
        try {
            attach = Application.class.getDeclaredMethod("attach", Context.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        attach.setAccessible(true);
        try {
            attach.invoke(delegate, mContext);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        delegate.onCreate();
    }

    @Override
    public String getPackageName() {
        return "";
    }

}
