package com.obo.mydemos.view.moutitouch;

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
public class MoutiTouchView extends View {
    public static String TAG = MoutiTouchView.class.getCanonicalName();
    //当前小球的位置
    private PointF currrentPosition = new PointF(100,100);
    //手指触摸起点坐标
    private PointF moveStartPosition = new PointF(0,0);
    //当前手指位置坐标
    private PointF moveEndPosition = new PointF(0,0);

    private Context context;

    public MoutiTouchView(Context context, AttributeSet attrs) {
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

        Log.i(TAG, "ActionIndex:" + event.getActionIndex());

        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG,"down :  X:"+event.getX(0)+"  Y:"+event.getY(0));
                moveStartPosition.x = event.getX();
                moveStartPosition.y = event.getY();
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.i(TAG,"point down 0:  X:"+event.getX(0)+"  Y:"+event.getY(0));
                Log.i(TAG,"point down 1:  X:"+event.getX(1)+"  Y:"+event.getY(1));
                break;

            case MotionEvent.ACTION_MOVE:

                Log.i(TAG,"point move 0:  X:"+event.getX(0)+"  Y:"+event.getY(0));
                if (event.getPointerCount() == 2)
                Log.i(TAG,"point move 1:  X:"+event.getX(1)+"  Y:"+event.getY(1));
                moveEndPosition.x = event.getX();
                moveEndPosition.y = event.getY();
                //刷新
                this.postInvalidate();
                break;

            case MotionEvent.ACTION_UP:
                Log.i(TAG,"up :  X:"+event.getX()+"  Y:"+event.getY());
                currrentPosition.x += (moveEndPosition.x - moveStartPosition.x);
                currrentPosition.y += (moveEndPosition.y - moveStartPosition.y);
                moveStartPosition.x = moveEndPosition.x;
                moveStartPosition.y = moveEndPosition.y;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.i(TAG,"point up 0:  X:"+event.getX(0)+"  Y:"+event.getY(0));
                Log.i(TAG,"point up 1:  X:"+event.getX(1)+"  Y:"+event.getY(1));

                break;
            default:
        }
        return true;
    }


}
