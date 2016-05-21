package com.me.obo.hocktest.view;

import android.graphics.Canvas;
import android.graphics.Matrix;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by obo on 16/5/20.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler() {
        super();
    }

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        if("lockCanvas".equals(method.getName())){
            System.out.println("++++++before " + method.getName() + "++++++");
            Object result = method.invoke(target, args);
            System.out.println("++++++after " + method.getName() + "++++++");
            Canvas canvas = (Canvas) result;
            Matrix matrix = new Matrix();
//            matrix.postTranslate(100,300);
            matrix.setScale(-1,1,300/2,400/2);
            canvas.setMatrix(matrix);

            return result;
        } if ("onDraw".equals(method.getName())) {
            Object result = method.invoke(target, args);
            return result;
        }
        else{
            Object result = method.invoke(target, args);
            return result;
        }

    }

}
