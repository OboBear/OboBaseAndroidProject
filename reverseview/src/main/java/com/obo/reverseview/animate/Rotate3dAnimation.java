package com.obo.reverseview.animate;

/**
 * Created by obo on 15/11/26.
 */

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {

    // 开始角度
    private final float mFromDegrees;
    // 结束角度
    private final float mToDegrees;
    // 中心点
    private final float mCenterX;
    private final float mCenterY;
    // 3D变换处理camera（不是摄像头）
    private Camera mCamera;

    /**
     * @param fromDegrees 起始角度
     * @param toDegrees 终止角度
     * @param centerX 翻转中心x坐标
     * @param centerY 翻转中心y坐标
     */
    public Rotate3dAnimation(float fromDegrees, float toDegrees, float centerX,
                             float centerY) {
        mFromDegrees    = fromDegrees;
        mToDegrees      = toDegrees;
        mCenterX        = centerX;
        mCenterY        = centerY;
    }

    @Override
    public void initialize(int width, int height, int parentWidth,
                           int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    // 生成Transformation
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegrees = mFromDegrees;
        // 生成中间角度
        float degrees = fromDegrees
                + ((mToDegrees - fromDegrees) * interpolatedTime);
        final float centerX = mCenterX;
        final float centerY = mCenterY;
        final Camera camera = mCamera;
        final Matrix matrix = t.getMatrix();
        camera.save();

        camera.rotateY(degrees);
        // 取得变换后的矩阵
        camera.getMatrix(matrix);

        camera.restore();
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }
}