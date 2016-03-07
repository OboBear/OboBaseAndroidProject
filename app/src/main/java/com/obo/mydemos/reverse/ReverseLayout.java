package com.obo.mydemos.reverse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by obo on 15/11/26.
 */
public class ReverseLayout extends LinearLayout {

    public ReverseLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        super.onInterceptTouchEvent(ev);


        return true;
    }

}
