package com.me.obo.hocktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.me.obo.hocktest.view.MyInvocationHandler;
import com.me.obo.hocktest.view.MySurfaceView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main2Activity extends AppCompatActivity {

    MySurfaceView mySurfaceView;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mySurfaceView = (MySurfaceView) findViewById(R.id.surfaceView);

        ViewParent v = mySurfaceView.getParent();

        ViewParent v2 = v.getParent();
        ViewParent v3 = v2.getParent();
        ViewParent v4 = v3.getParent();
        ViewParent v5 = v4.getParent();

        FrameLayout v6 = (FrameLayout) v5.getParent();
        v6.setScaleY(-1);
//        InvocationHandler invocationHandler = new MyInvocationHandler(v6);
//        FrameLayout frameLayout = (FrameLayout) Proxy.newProxyInstance(v6.getClass().getClassLoader(),
//                v6.getClass().getInterfaces(), invocationHandler);

        ViewParent v7 = v6.getParent();

//        ViewParent v8 = v7.getParent();
//        ViewParent v9 = v8.getParent();
//        ViewParent v10 = v9.getParent();

        LayoutInflater layoutInflater;

        Window win = getWindow();

        WindowManager w = getWindowManager();

        startActivity(new Intent(this,MainActivity.class));
        Toast.makeText(this,"",Toast.LENGTH_SHORT);

        try {
            ttt();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

//        try {
//            holk();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        App v = (App) getApplication();
//        v.printA();

    }


    public void holk() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class c = Class.forName("com.me.obo.hocktest.App");
        Field fielA = c.getDeclaredField("a");
        fielA.setAccessible(true);
        App a = (App) getApplication();
        fielA.set(a,"hello");
        a.printA();

    }


    public void ttt() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException {


        Class c = Class.forName("android.view.SurfaceView");

        Field fieldHolder = c.getDeclaredField("mSurfaceHolder");

        fieldHolder.setAccessible(true);

        SurfaceHolder holder = (SurfaceHolder) fieldHolder.get(mySurfaceView);


        Class SurfaceHolderClass = SurfaceHolder.class;

        Method lockCanvasMethod =SurfaceHolderClass.getDeclaredMethod("lockCanvas");

        lockCanvasMethod.setAccessible(true);


//        InvocationHandler invocationHandler = new MyInvocationHandler(holder);
//        SurfaceHolder newHolder = (SurfaceHolder) Proxy.newProxyInstance(holder.getClass().getClassLoader(),
//                holder.getClass().getInterfaces(), invocationHandler);
//
//        fieldHolder.set(mySurfaceView,newHolder);

        Log.i("","");

    }



}
