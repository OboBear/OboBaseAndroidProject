package com.example.obo.dashboard.animate;

import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;

/**
 * Created by obo on 16/3/23.
 * Email:obo1993@gmail.com
 */
public class CompassRotateAnimation extends RotateAnimation {

    private static final String TAG = CompassRotateAnimation.class.getCanonicalName();

    public CompassRotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY ) {
        super(fromDegrees, toDegrees, pivotX, pivotY);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
    }
}
