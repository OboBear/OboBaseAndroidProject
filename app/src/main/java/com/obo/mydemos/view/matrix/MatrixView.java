package com.obo.mydemos.view.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by obo on 15/8/26.
 */
public class MatrixView extends View {

    public final static String TAG = MatrixView.class.getCanonicalName();
    //bitmap运行矩阵
    Matrix matrix = new Matrix();
    //记录点
    PointF startPoint = new PointF();
    //自定义bitmap
    Bitmap bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Canvas canvas = new Canvas(bitmap);
        //直接在bitmap上面绘制一个小球
        canvas.drawCircle(50,50,50,new Paint());
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        Paint paint = new Paint();

        canvas.drawBitmap(bitmap, matrix, new Paint());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        super.onTouchEvent(event);

        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y );

                //刷新
                this.postInvalidate();
                break;

            case MotionEvent.ACTION_UP:

                break;

            default:
        }

        startPoint.x = event.getX();
        startPoint.y = event.getY();

        Log.i(TAG,""+startPoint.x );
        return true;

    }

}
