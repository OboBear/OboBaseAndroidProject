package com.obo.mydemos.view.singletouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by obo on 15/8/21.
 */
public class SingleTouchView extends View {

    public static String TAG = SingleTouchView.class.getCanonicalName();
    //当前小球的位置
    private PointF currrentPosition = new PointF(100,100);
    //手指触摸起点坐标
    private PointF moveStartPosition = new PointF(0,0);
    //当前手指位置坐标
    private PointF moveEndPosition = new PointF(0,0);

    private Context context;

    public SingleTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawCircle(currrentPosition.x + (moveEndPosition.x - moveStartPosition.x),currrentPosition.y+(moveEndPosition.y - moveStartPosition.y),50,new Paint());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                moveStartPosition.x = event.getX();
                moveStartPosition.y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveEndPosition.x = event.getX();
                moveEndPosition.y = event.getY();
                //刷新
                this.postInvalidate();
                break;

            case MotionEvent.ACTION_UP:
                currrentPosition.x += (moveEndPosition.x - moveStartPosition.x);
                currrentPosition.y += (moveEndPosition.y - moveStartPosition.y);
                moveStartPosition.x = moveEndPosition.x;
                moveStartPosition.y = moveEndPosition.y;
                break;
            default:
        }
        return true;
    }

}
