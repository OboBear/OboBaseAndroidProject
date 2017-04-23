package com.me.obo.roundrectlinearlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by obo on 16/7/18.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class RoundRectLinearLayout extends LinearLayout {

    private float mCornerXValue ;
    private float mCornerYValue ;

    public RoundRectLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 获取自定义参数
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.RoundImageView);
        // 获取X方向曲率
        mCornerXValue = typedArray.getDimension(R.styleable.RoundImageView_corner_x,0);
        // 获取Y方向曲率
        mCornerYValue = typedArray.getDimension(R.styleable.RoundImageView_corner_y,0);
        // 用完需要recycle
        typedArray.recycle();

        initPaints();
    }

    private void initPaints() {
        // 创建普通画笔
        if (mNomalPaint == null) {
            mNomalPaint = new Paint();
            mNomalPaint.setAntiAlias(true);
        }

        // 创建遮罩画笔
        if (mPaintClip == null) {
            mPaintClip = new Paint();
            mPaintClip.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            mPaintClip.setAntiAlias(true);
        }

    }

    Bitmap mDestBitmap;
    Bitmap mSrcBitmap;
    Canvas mSrcCanvas;
    Canvas mDestCanvas;
    Paint mPaintClip;
    Paint mNomalPaint;
    RectF mRoundRectClip;

    @Override
    public void draw(Canvas canvas) {

        // 创建遮罩图片和画布
        if (mDestBitmap == null) {
            mDestBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mSrcBitmap = Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
            mDestCanvas = new Canvas(mDestBitmap);
            mSrcCanvas = new Canvas(mSrcBitmap);
        }
        // 获取imageview原先的图片
        super.draw(mDestCanvas);

        // 创建矩形，表示圆角矩形
        if (mRoundRectClip == null) {
            mRoundRectClip = new RectF(0, 0, getWidth() , getHeight() );
        }
        // 绘制圆角矩形
        mSrcCanvas.drawRoundRect(mRoundRectClip,mCornerXValue,mCornerYValue,mNomalPaint);

        // 使用遮罩画笔扣除原图中的圆角矩形外面的部分
        mDestCanvas.drawBitmap(mSrcBitmap,0,0,mPaintClip);
        mDestCanvas.drawText("123",50,50,mNomalPaint);

        // 绘制最终的圆角带有board的图
        canvas.drawBitmap(mDestBitmap,0,0,mNomalPaint);

        setBackgroundColor(Color.RED);
    }
}
