package com.me.obo.roundrectlinearlayout;

import android.view.LayoutInflater;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by obo on 16/7/31.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class LayoutInvocation implements InvocationHandler{

    Object mObject;
    public LayoutInvocation(Object object) {
        mObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        return method.invoke(mObject,args);
    }
}
