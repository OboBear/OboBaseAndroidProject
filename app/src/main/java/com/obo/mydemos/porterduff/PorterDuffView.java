package com.obo.mydemos.porterduff;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.obo.activity.R;

/**
 * Created by obo on 15/9/9.
 */
public class PorterDuffView extends View{

    Bitmap Dst;
    Bitmap Src;

    public PorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Dst = Bitmap.createBitmap(300,300, Bitmap.Config.ARGB_8888);
        Src = Bitmap.createBitmap(300,300, Bitmap.Config.ARGB_8888);

        Canvas canvas1 = new Canvas(Dst);
        Paint paintRect = new Paint();
        paintRect.setColor(Color.RED);
        canvas1.drawRect(0, 0, 150, 500, paintRect);

        Canvas canvas2 = new Canvas(Src);
        canvas2.drawCircle(120,120,80,new Paint());

        Paint porterDuffPaint = new Paint();
        porterDuffPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas1.drawBitmap(Src, 0, 0, porterDuffPaint);

    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawBitmap(Dst, 100, 50, new Paint());
    }
}
