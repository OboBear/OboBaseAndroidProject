package com.example.obo.dashboard.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.obo.dashboard.R;

/**
 * Created by obo on 16/3/22.
 * Email:obo1993@gmail.com
 */
public class ColorDragView extends View implements Runnable{

    Matrix mMtxDashBoardColorCover;

    Bitmap mBmpDashBoardColorCover;
    Bitmap mBmpResult;
    Bitmap mBmpBlackMask;
    Bitmap mBmpArcMask;

    Bitmap mBmpDashBoardDegreenCover;

    Canvas mCvsResult;
    Canvas mCvsArc;

    double degreen = 0;

    public ColorDragView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mMtxDashBoardColorCover = new Matrix();

        mBmpDashBoardDegreenCover = BitmapFactory
                .decodeResource(context.getResources(), R.drawable.digreen_cover_round);

        mBmpDashBoardColorCover = BitmapFactory
                .decodeResource(context.getResources(), R.drawable.dashboard_point_cover);

        mBmpBlackMask = Bitmap.createBitmap(mBmpDashBoardDegreenCover.getWidth(), mBmpDashBoardDegreenCover.getHeight(), Bitmap.Config.ARGB_4444);
        mBmpResult = Bitmap.createBitmap(mBmpDashBoardDegreenCover.getWidth(), mBmpDashBoardDegreenCover.getHeight(), Bitmap.Config.ARGB_8888);
        mBmpArcMask = Bitmap.createBitmap(mBmpDashBoardDegreenCover.getWidth(), mBmpDashBoardDegreenCover.getHeight(), Bitmap.Config.ARGB_8888);

        mCvsResult = new Canvas(mBmpResult);
        new Canvas(mBmpBlackMask).drawColor(Color.BLACK);

        mCvsArc = new Canvas(mBmpArcMask);

        RectF oval2 = new RectF(0, 0, mBmpDashBoardDegreenCover.getWidth(),mBmpDashBoardDegreenCover.getHeight());
        mCvsArc.drawArc(oval2, 45, 90, true, getPaint());
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        mCvsArc.drawBitmap(mBmpBlackMask, 0, 0, getClearPaint());
        RectF oval2 = new RectF(0, 0, mBmpDashBoardDegreenCover.getWidth(),mBmpDashBoardDegreenCover.getHeight());
        mCvsArc.drawArc(oval2, 135, (float) (-360 + degreen), true, getPaint());

        mCvsResult.drawBitmap(mBmpBlackMask, 0, 0, getClearPaint());
        mMtxDashBoardColorCover.setTranslate(0, 0);
        mMtxDashBoardColorCover.setRotate((float) (degreen - 90), mBmpDashBoardColorCover.getWidth() / 2,
                mBmpDashBoardColorCover.getHeight() / 2);
        mMtxDashBoardColorCover.postTranslate(mBmpDashBoardDegreenCover.getWidth() / 2 - mBmpDashBoardColorCover.getWidth() / 2,
                mBmpDashBoardDegreenCover.getHeight() / 2 - mBmpDashBoardColorCover.getHeight() / 2);

        mCvsResult.drawBitmap(mBmpDashBoardDegreenCover, 0, 0, getPaint());
        mCvsResult.drawBitmap(mBmpDashBoardColorCover, mMtxDashBoardColorCover, getPaint());

        //抠除
        mCvsResult.drawBitmap(mBmpArcMask, 0, 0, getMaskPaint());

        canvas.drawBitmap(mBmpResult, getWidth() / 2 - mBmpDashBoardDegreenCover.getWidth() / 2, getHeight() / 2 - mBmpDashBoardDegreenCover.getHeight() / 2, new Paint());
    }

    double lastDegreen;
    double destinationDegreen;
    double distanceDegreen;
    int stap;
    public double randANewValue(float speedValue) {

        lastDegreen = destinationDegreen;
        degreen = lastDegreen;

        double value = speedValue;
        destinationDegreen = value * 270 / 150;

        distanceDegreen = (destinationDegreen - lastDegreen)/100;

        new Thread(this).start();

        return value;
    }

    @Override
    public void run() {
        while (stap++ <100) {

            degreen += distanceDegreen;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.postInvalidate();
        }
        stap = 0;
    }


    Paint mClearPaint;
    Paint mMaskPaint;
    Paint mPaint;
    private Paint getClearPaint() {
        if (mClearPaint == null) {
            mClearPaint = new Paint();
            mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        return mClearPaint;
    }

    private Paint getMaskPaint() {
        if (mMaskPaint == null) {
            mMaskPaint = new Paint();
            mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
        return mMaskPaint;
    }

    private Paint getPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
        }
        return mPaint ;
    }

}
