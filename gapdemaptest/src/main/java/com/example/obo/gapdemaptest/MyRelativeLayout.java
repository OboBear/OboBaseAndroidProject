package com.example.obo.gapdemaptest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by obo on 16/3/11.
 * Email:uuu1993@gmail.com
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.i("","onInterceptTouchEvent:"+System.currentTimeMillis());
        boolean flag = super.onInterceptTouchEvent(ev);
        return flag;
    }
}
