package com.example.obo.animationloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by obo on 16/3/29.
 * Email:obo1993@gmail.com
 */
public class CircleButton extends Button {
    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2 - 2, paint);
        super.onDraw(canvas);
    }
}
