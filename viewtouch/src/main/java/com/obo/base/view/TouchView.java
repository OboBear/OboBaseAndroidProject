package com.obo.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by obo on 15/8/21.
 */
public class TouchView extends View{

    public static String TAG = TouchView.class.getCanonicalName();

    private PointF currrentPosition = new PointF(100,100);

    private PointF movePositionStart = new PointF(0,0);

    private PointF movePositionMoving = new PointF(0,0);

    private Context context;

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawCircle(currrentPosition.x + (movePositionMoving.x - movePositionStart.x),currrentPosition.y+(movePositionMoving.y - movePositionStart.y),50,new Paint());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                movePositionStart.x = event.getX();
                movePositionStart.y = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                movePositionMoving.x = event.getX();
                movePositionMoving.y = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                currrentPosition.x += (movePositionMoving.x - movePositionStart.x);
                currrentPosition.y += (movePositionMoving.y - movePositionStart.y);
                movePositionMoving.x = 0;
                movePositionMoving.y = 0;
                movePositionStart.x = 0;
                movePositionStart.y = 0;
                break;
            case MotionEvent.ACTION_CANCEL:
                break;

            default:
        }

        this.postInvalidate();

        return true;
    }
}
