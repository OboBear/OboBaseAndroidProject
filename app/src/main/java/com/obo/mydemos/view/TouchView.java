package com.obo.mydemos.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by obo on 15/8/21.
 */
public class TouchView extends View {
    public String TAG = TouchView.class.getCanonicalName();

    private Context context;


    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawCircle(100,100,50,new Paint());
    }
}
