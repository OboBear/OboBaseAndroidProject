package com.obo.reverseview.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by obo on 15/12/4.
 */
public class ReverseLayout extends FrameLayout {

    public boolean isReverse = true;

    public ReverseLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {

        if (isReverse)
            canvas.scale(-1, 1, getWidth() / 2, getHeight() / 2);

        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ev.setLocation(ev.getX(),ev.getY());
        return super.onInterceptTouchEvent(ev);
    }
}
