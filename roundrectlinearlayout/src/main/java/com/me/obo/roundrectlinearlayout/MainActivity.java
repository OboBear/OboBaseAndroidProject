package com.me.obo.roundrectlinearlayout;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {


    LinearLayout layout_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout_i = (LinearLayout) findViewById(R.id.layout_i);

        // 创建代理接口的实现
        LayoutInvocation testInvocation = new LayoutInvocation(layout_i);
        // 为 mSurfaceHolder 添加动态代理,并获取添加代理之后的 newSurfaceHolder
        Drawable.Callback newLayout = (Drawable.Callback)Proxy.newProxyInstance(Drawable.Callback.class.getClassLoader(),new Class[]{Drawable.Callback.class},testInvocation);

        ViewGroup parent = (ViewGroup) layout_i.getParent();



        Class cc = LinearLayout.class;

        try {
            Method m = cc.getDeclaredMethod("");

            Field f = cc.getDeclaredField("");

            Class[] s = cc.getInterfaces();


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

//        for (int i=0;i<parent.getChildCount();i++) {
//            View child = parent.getChildAt(i);
//            if (child == layout_i) {
//                parent.removeViewAt(i);
//                parent.addView(newLayout,i);
//            }
//        }

    }
}
