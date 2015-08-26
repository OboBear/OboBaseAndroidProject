package com.obo.mydemos.view.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by obo on 15/8/26.
 */
public class MatrixView extends View {

    public final static String TAG = MatrixView.class.getCanonicalName();

    Matrix matrix = new Matrix();

    Bitmap bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Canvas canvas = new Canvas(bitmap);

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


        switch (event.getAction())
        {

            case MotionEvent.ACTION_DOWN:
                break;



        }




        return true;

    }

}
