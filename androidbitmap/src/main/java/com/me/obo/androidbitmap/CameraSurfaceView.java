package com.me.obo.androidbitmap;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by obo on 16/4/27.
 * Email:obo1993@gmail.com
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    public CameraSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getHolder().addCallback(this);
    }




    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        Camera camera =
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
