package com.example.obo.animationloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by obo on 16/3/31.
 * Email:obo1993@gmail.com
 */
public class AnimateView extends View {
    private int mWidth = 2;
    private int mDegreen = 70;
    Paint paint;

    public AnimateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void setData(int width, int degreen) {
        mWidth = width;
        mDegreen = degreen;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(mWidth);
        canvas.drawArc(new RectF(0, 0, getHeight(), getHeight()), 0, mDegreen, false, paint);
        canvas.drawArc(new RectF(0, 0, getHeight(), getHeight()), 180, mDegreen, false, paint);
    }
}
