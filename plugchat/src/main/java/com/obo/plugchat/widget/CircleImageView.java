package com.obo.plugchat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by obo on 16/1/31.
 */
public class CircleImageView extends ImageView {

    Bitmap bmpDest = null;
    Bitmap bmpCover = null;

    Bitmap bmpResult = null;


    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (bmpDest == null) {
            bmpDest = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        }

        if (bmpCover == null) {
            bmpCover = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvasCover = new Canvas(bmpCover);
            canvasCover.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, new Paint());
        }

        Canvas canvasBitmap = new Canvas(bmpDest);
        super.onDraw(canvasBitmap);

        if (bmpResult == null) {
            bmpResult = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvasResult = new Canvas(bmpResult);
            canvasResult.drawBitmap(bmpDest, 0, 0, new Paint());
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            paint.setAntiAlias(true);
            canvasResult.drawBitmap(bmpCover, 0, 0, paint);
        }
        canvas.drawBitmap(bmpResult, 0, 0, new Paint());



        Paint strokePaint = new Paint();
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(4);
        strokePaint.setAntiAlias(true);
        strokePaint.setAlpha(50);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 2, strokePaint);
    }

}
