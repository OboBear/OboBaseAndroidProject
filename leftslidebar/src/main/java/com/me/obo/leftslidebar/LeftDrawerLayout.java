package com.me.obo.leftslidebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by obo on 16/4/25.
 * Email:obo1993@gmail.com
 */
public class LeftDrawerLayout extends FrameLayout {

    boolean mIsShow = false;

    public LeftDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    /**
     * Change the show status of left drawer. It will do something if the show status is different
     * @param isShow true to show the left drawer , false otherwise. Default value is false.
     */
    public void setLeftDrawerShowStatus(boolean isShow) {
        if (mIsShow != isShow) {
            mIsShow = isShow;

            if (mIsShow) {

            }
        }
     }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getX() < 100 && ev.getX() - ev.getXPrecision() > 5 && Math.abs(ev.getY() - ev.getYPrecision()) < 3) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);

    }
}
