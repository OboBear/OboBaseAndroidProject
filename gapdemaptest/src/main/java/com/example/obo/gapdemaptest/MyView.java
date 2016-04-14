package com.example.obo.gapdemaptest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by obo on 16/3/12.
 * Email:uuu1993@gmail.com
 */
public class MyView extends View {
    Paint mPaint;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawRect(0,0,200, 200,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
