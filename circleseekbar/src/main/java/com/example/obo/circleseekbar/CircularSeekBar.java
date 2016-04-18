/*
 * 
 * Copyright 2013 Matt Joseph
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * 
 * 
 * This custom view/widget was inspired and guided by:
 * 
 * HoloCircleSeekBar - Copyright 2012 Jes�s Manzano
 * HoloColorPicker - Copyright 2012 Lars Werkman (Designed by Marie Schweiz)
 * 
 * Although I did not used the code from either project directly, they were both used as 
 * reference material, and as a result, were extremely helpful.
 */

package com.example.obo.circleseekbar;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;



/**
 * reference https://github.com/devadvance/circularseekbar
 */
public class CircularSeekBar extends View implements ValueAnimator.AnimatorUpdateListener {

    /**
     * Used to scale the dp units to pixels
     */
    protected final float DPTOPX_SCALE = getResources().getDisplayMetrics().density;

    /**
     * Minimum touch target size in DP. 48dp is the Android design recommendation
     */
    protected final float MIN_TOUCH_TARGET_DP = 48;

    // Default values
    protected static final float DEFAULT_CIRCLE_X_RADIUS = 30f;
    protected static final float DEFAULT_CIRCLE_Y_RADIUS = 30f;
    protected static final float DEFAULT_POINTER_RADIUS = 7f;
    protected static final float DEFAULT_POINTER_HALO_WIDTH = 6f;
    protected static final float DEFAULT_POINTER_HALO_BORDER_WIDTH = 2f;
    protected static final float DEFAULT_CIRCLE_STROKE_WIDTH = 5f;
    protected static final float DEFAULT_START_ANGLE = 0f; // Geometric (clockwise, relative to 3 o'clock)
    protected static final float DEFAULT_END_ANGLE = 0f; // Geometric (clockwise, relative to 3 o'clock)
    protected static final int DEFAULT_MAX = 100;
    protected static final int DEFAULT_PROGRESS = 0;
    protected static final int DEFAULT_CIRCLE_COLOR = Color.RED;
    protected static final int DEFAULT_CIRCLE_PROGRESS_COLOR = Color.argb(235, 74, 138, 255);
    protected static final int DEFAULT_POINTER_COLOR = Color.argb(235, 74, 138, 255);
    protected static final int DEFAULT_POINTER_HALO_COLOR = Color.argb(135, 74, 138, 255);
    protected static final int DEFAULT_POINTER_HALO_COLOR_ONTOUCH = Color.argb(135, 74, 138, 255);
    protected static final int DEFAULT_CIRCLE_FILL_COLOR = Color.TRANSPARENT;
    protected static final int DEFAULT_POINTER_ALPHA = 135;
    protected static final int DEFAULT_POINTER_ALPHA_ONTOUCH = 100;
    protected static final boolean DEFAULT_USE_CUSTOM_RADII = false;
    protected static final boolean DEFAULT_MAINTAIN_EQUAL_CIRCLE = true;
    protected static final boolean DEFAULT_MOVE_OUTSIDE_CIRCLE = false;
    protected static final boolean DEFAULT_LOCK_ENABLED = true;

    static final int DEFAULT_PROGRESS_TEXT_COLOR = Color.WHITE;
    static final int DEFAULT_PROGRESS_TEXT_SIZE = 0;

    private TextPaint mProgressTextPaint;
    private float mProgressTextWidth;
    private float mProgressTextHeight;

    /**
     * {@code Paint} instance used to draw the inactive circle.
     */
    protected Paint mCirclePaint;

    /**
     * {@code Paint} instance used to draw the circle fill.
     */
    protected Paint mCircleFillPaint;

    /**
     * {@code Paint} instance used to draw the active circle (represents progress).
     */
    protected Paint mCircleProgressPaint;

    /**
     * {@code Paint} instance used to draw the glow from the active circle.
     */
    protected Paint mCircleProgressGlowPaint;

    /**
     * {@code Paint} instance used to draw the center of the pointer.
     * Note: This is broken on 4.0+, as BlurMasks do not work with hardware acceleration.
     */
    protected Paint mPointerPaint;

    /**
     * {@code Paint} instance used to draw the halo of the pointer.
     * Note: The halo is the part that changes transparency.
     */
    protected Paint mPointerHaloPaint;

    /**
     * {@code Paint} instance used to draw the border of the pointer, outside of the halo.
     */
    protected Paint mPointerHaloBorderPaint;

    /**
     * The width of the circle (in pixels).
     */
    protected float mCircleStrokeWidth;

    /**
     * The X radius of the circle (in pixels).
     */
    protected float mCircleXRadius;

    /**
     * The Y radius of the circle (in pixels).
     */
    protected float mCircleYRadius;

    /**
     * The radius of the pointer (in pixels).
     */
    protected float mPointerRadius;

    /**
     * The width of the pointer halo (in pixels).
     */
    protected float mPointerHaloWidth;

    /**
     * The width of the pointer halo border (in pixels).
     */
    protected float mPointerHaloBorderWidth;

    /**
     * Start angle of the CircularSeekBar.
     * Note: If mStartAngle and mEndAngle are set to the same angle, 0.1 is subtracted
     * from the mEndAngle to make the circle function properly.
     */
    protected float mStartAngle;

    /**
     * End angle of the CircularSeekBar.
     * Note: If mStartAngle and mEndAngle are set to the same angle, 0.1 is subtracted
     * from the mEndAngle to make the circle function properly.
     */
    protected float mEndAngle;

    /**
     * {@code RectF} that represents the circle (or ellipse) of the seekbar.
     */
    protected RectF mCircleRectF = new RectF();

    protected RectF mProgressTextCircleRectF = new RectF();

    /**
     * Holds the color value for {@code mPointerPaint} before the {@code Paint} instance is created.
     */
    protected int mPointerColor = DEFAULT_POINTER_COLOR;

    /**
     * Holds the color value for {@code mPointerHaloPaint} before the {@code Paint} instance is created.
     */
    protected int mPointerHaloColor = DEFAULT_POINTER_HALO_COLOR;

    /**
     * Holds the color value for {@code mPointerHaloPaint} before the {@code Paint} instance is created.
     */
    protected int mPointerHaloColorOnTouch = DEFAULT_POINTER_HALO_COLOR_ONTOUCH;

    /**
     * Holds the color value for {@code mCirclePaint} before the {@code Paint} instance is created.
     */
    protected int mCircleColor = DEFAULT_CIRCLE_COLOR;

    /**
     * Holds the color value for {@code mCircleFillPaint} before the {@code Paint} instance is created.
     */
    protected int mCircleFillColor = DEFAULT_CIRCLE_FILL_COLOR;

    /**
     * Holds the color value for {@code mCircleProgressPaint} before the {@code Paint} instance is created.
     */
    protected int mCircleProgressColor = DEFAULT_CIRCLE_PROGRESS_COLOR;

    /**
     * Holds the alpha value for {@code mPointerHaloPaint}.
     */
    protected int mPointerAlpha = DEFAULT_POINTER_ALPHA;

    /**
     * Holds the OnTouch alpha value for {@code mPointerHaloPaint}.
     */
    protected int mPointerAlphaOnTouch = DEFAULT_POINTER_ALPHA_ONTOUCH;

    /**
     * Distance (in degrees) that the the circle/semi-circle makes up.
     * This amount represents the max of the circle in degrees.
     */
    protected float mTotalCircleDegrees;

    /**
     * Distance (in degrees) that the current progress makes up in the circle.
     */
    protected float mProgressDegrees;

    /**
     * {@code Path} used to draw the circle/semi-circle.
     */
    protected Path mCirclePath;

    /**
     * {@code Path} used to draw the progress on the circle.
     */
    protected Path mCircleProgressPath;

    protected Path mProgressTextPath;

    /**
     * Max value that this CircularSeekBar is representing.
     */
    protected int mMax;

    /**
     * Progress value that this CircularSeekBar is representing.
     */
    protected int mProgress;

    /**
     * If true, then the user can specify the X and Y radii.
     * If false, then the View itself determines the size of the CircularSeekBar.
     */
    protected boolean mCustomRadii;

    /**
     * Maintain a perfect circle (equal x and y radius), regardless of view or custom attributes.
     * The smaller of the two radii will always be used in this case.
     * The default is to be a circle and not an ellipse, due to the behavior of the ellipse.
     */
    protected boolean mMaintainEqualCircle;

    /**
     * Once a user has touched the circle, this determines if moving outside the circle is able
     * to change the position of the pointer (and in turn, the progress).
     */
    protected boolean mMoveOutsideCircle;

    /**
     * Used for enabling/disabling the lock option for easier hitting of the 0 progress mark.
     */
    protected boolean lockEnabled = true;

    /**
     * Used for when the user moves beyond the start of the circle when moving counter clockwise.
     * Makes it easier to hit the 0 progress mark.
     */
    protected boolean lockAtStart = true;

    /**
     * Used for when the user moves beyond the end of the circle when moving clockwise.
     * Makes it easier to hit the 100% (max) progress mark.
     */
    protected boolean lockAtEnd = false;

    /**
     * When the user is touching the circle on ACTION_DOWN, this is set to true.
     * Used when touching the CircularSeekBar.
     */
    protected boolean mUserIsMovingPointer = false;


    protected boolean hasProgressText = false;

    /**
     * Represents the clockwise distance from {@code mStartAngle} to the touch angle.
     * Used when touching the CircularSeekBar.
     */
    protected float cwDistanceFromStart;

    /**
     * Represents the counter-clockwise distance from {@code mStartAngle} to the touch angle.
     * Used when touching the CircularSeekBar.
     */
    protected float ccwDistanceFromStart;

    /**
     * Represents the clockwise distance from {@code mEndAngle} to the touch angle.
     * Used when touching the CircularSeekBar.
     */
    protected float cwDistanceFromEnd;

    /**
     * Represents the counter-clockwise distance from {@code mEndAngle} to the touch angle.
     * Used when touching the CircularSeekBar.
     * Currently unused, but kept just in case.
     */
    @SuppressWarnings("unused")
    protected float ccwDistanceFromEnd;

    /**
     * The previous touch action value for {@code cwDistanceFromStart}.
     * Used when touching the CircularSeekBar.
     */
    protected float lastCWDistanceFromStart;

    /**
     * Represents the clockwise distance from {@code mPointerPosition} to the touch angle.
     * Used when touching the CircularSeekBar.
     */
    protected float cwDistanceFromPointer;

    /**
     * Represents the counter-clockwise distance from {@code mPointerPosition} to the touch angle.
     * Used when touching the CircularSeekBar.
     */
    protected float ccwDistanceFromPointer;

    /**
     * True if the user is moving clockwise around the circle, false if moving counter-clockwise.
     * Used when touching the CircularSeekBar.
     */
    protected boolean mIsMovingCW;

    /**
     * The width of the circle used in the {@code RectF} that is used to draw it.
     * Based on either the View width or the custom X radius.
     */
    protected float mCircleWidth;

    /**
     * The height of the circle used in the {@code RectF} that is used to draw it.
     * Based on either the View width or the custom Y radius.
     */
    protected float mCircleHeight;

    /**
     * Represents the progress mark on the circle, in geometric degrees.
     * This is not provided by the user; it is calculated;
     */
    protected float mPointerPosition;

    /**
     * Pointer position in terms of X and Y coordinates.
     */
    protected float[] mPointerPositionXY = new float[2];

    protected float[] mProgressTextPositionXY = new float[2];

    protected int mProgressTextColor = Color.WHITE;

    protected int mProgressTextDimension = 0;

    String mProgressString;


    /**
     * Listener.
     */
    protected OnCircularSeekBarChangeListener mOnCircularSeekBarChangeListener;

    /**
     * True if user touch input is enabled, false if user touch input is ignored.
     * This does not affect setting values programmatically.
     */
    protected boolean isTouchEnabled = true;
    private boolean showTextATLowPercent = false;
    private boolean enableProgressText;
    private boolean enablePoint = true;
    private boolean enableShader;
    private String TAG = "CircularSeekBar";
    private Path mHighligtProgressArcPath;
    private Paint mHighligtProgressArcPaint;
    private ObjectAnimator animator;


    /**
     * Initialize the CircularSeekBar with the attributes from the XML style.
     * Uses the defaults defined at the top of this file when an attribute is not specified by the user.
     *
     * @param attrArray TypedArray containing the attributes.
     */
    protected void initAttributes(TypedArray attrArray) {
        mCircleXRadius = attrArray.getDimension(R.styleable.CircularSeekBar_circle_x_radius, DEFAULT_CIRCLE_X_RADIUS * DPTOPX_SCALE);
        mCircleYRadius = attrArray.getDimension(R.styleable.CircularSeekBar_circle_y_radius, DEFAULT_CIRCLE_Y_RADIUS * DPTOPX_SCALE);
        mPointerRadius = attrArray.getDimension(R.styleable.CircularSeekBar_pointer_radius, DEFAULT_POINTER_RADIUS * DPTOPX_SCALE);
        mPointerHaloWidth = attrArray.getDimension(R.styleable.CircularSeekBar_pointer_halo_width, DEFAULT_POINTER_HALO_WIDTH * DPTOPX_SCALE);
        mPointerHaloBorderWidth = attrArray.getDimension(R.styleable.CircularSeekBar_pointer_halo_border_width, DEFAULT_POINTER_HALO_BORDER_WIDTH * DPTOPX_SCALE);
        mCircleStrokeWidth = attrArray.getDimension(R.styleable.CircularSeekBar_circle_stroke_width, DEFAULT_CIRCLE_STROKE_WIDTH * DPTOPX_SCALE);

        mPointerColor = attrArray.getColor(R.styleable.CircularSeekBar_pointer_color, DEFAULT_POINTER_COLOR);
        mPointerHaloColor = attrArray.getColor(R.styleable.CircularSeekBar_pointer_halo_color, DEFAULT_POINTER_HALO_COLOR);
        mPointerHaloColorOnTouch = attrArray.getColor(R.styleable.CircularSeekBar_pointer_halo_color_ontouch, DEFAULT_POINTER_HALO_COLOR_ONTOUCH);
        mCircleColor = attrArray.getColor(R.styleable.CircularSeekBar_circle_color, DEFAULT_CIRCLE_COLOR);
        mCircleProgressColor = attrArray.getColor(R.styleable.CircularSeekBar_circle_progress_color, DEFAULT_CIRCLE_PROGRESS_COLOR);
        mCircleFillColor = attrArray.getColor(R.styleable.CircularSeekBar_circle_fill, DEFAULT_CIRCLE_FILL_COLOR);

        mPointerAlpha = Color.alpha(mPointerHaloColor);

        mPointerAlphaOnTouch = attrArray.getInt(R.styleable.CircularSeekBar_pointer_alpha_ontouch, DEFAULT_POINTER_ALPHA_ONTOUCH);
        if (mPointerAlphaOnTouch > 255 || mPointerAlphaOnTouch < 0) {
            mPointerAlphaOnTouch = DEFAULT_POINTER_ALPHA_ONTOUCH;
        }

        mMax = attrArray.getInt(R.styleable.CircularSeekBar_max, DEFAULT_MAX);
        mProgress = attrArray.getInt(R.styleable.CircularSeekBar_progress, DEFAULT_PROGRESS);
        mCustomRadii = attrArray.getBoolean(R.styleable.CircularSeekBar_use_custom_radii, DEFAULT_USE_CUSTOM_RADII);
        mMaintainEqualCircle = attrArray.getBoolean(R.styleable.CircularSeekBar_maintain_equal_circle, DEFAULT_MAINTAIN_EQUAL_CIRCLE);
        mMoveOutsideCircle = attrArray.getBoolean(R.styleable.CircularSeekBar_move_outside_circle, DEFAULT_MOVE_OUTSIDE_CIRCLE);
        lockEnabled = attrArray.getBoolean(R.styleable.CircularSeekBar_lock_enabled, DEFAULT_LOCK_ENABLED);


        mProgressTextColor = attrArray.getColor(R.styleable.CircularSeekBar_progressTextColor, DEFAULT_PROGRESS_TEXT_COLOR);
        mProgressTextDimension = attrArray.getDimensionPixelSize(R.styleable.CircularSeekBar_progressTextSize, DEFAULT_PROGRESS_TEXT_SIZE);

        showTextATLowPercent = attrArray.getBoolean(R.styleable.CircularSeekBar_showTextAtLowPercent, false);

        enableProgressText = attrArray.getBoolean(R.styleable.CircularSeekBar_enableProgressText, true);
        enablePoint = attrArray.getBoolean(R.styleable.CircularSeekBar_pointEnable, true);
        enableShader = attrArray.getBoolean(R.styleable.CircularSeekBar_shaderEnable, false);

        // Modulo 360 right now to avoid constant conversion
        mStartAngle = ((360f + (attrArray.getFloat((R.styleable.CircularSeekBar_start_angle), DEFAULT_START_ANGLE) % 360f)) % 360f);
        mEndAngle = ((360f + (attrArray.getFloat((R.styleable.CircularSeekBar_end_angle), DEFAULT_END_ANGLE) % 360f)) % 360f);

        if (mStartAngle == mEndAngle) {
            //mStartAngle = mStartAngle + 1f;
            mEndAngle = mEndAngle - .1f;
        }
    }

    /**
     * Initializes the {@code Paint} objects with the appropriate styles.
     */
    protected void initPaints() {
//        mCirclePaint = new Paint();
//        mCirclePaint.setAntiAlias(true);
//        mCirclePaint.setDither(true);
//        mCirclePaint.setColor(mCircleColor);
//        mCirclePaint.setStrokeWidth(mCircleStrokeWidth);
//        mCirclePaint.setStyle(Paint.Style.STROKE);
//        mCirclePaint.setStrokeJoin(Paint.Join.ROUND);
//        mCirclePaint.setStrokeCap(Paint.Cap.ROUND);

        mCircleFillPaint = new Paint();
        mCircleFillPaint.setAntiAlias(true);
        mCircleFillPaint.setDither(true);
        mCircleFillPaint.setColor(mCircleFillColor);
        mCircleFillPaint.setStyle(Paint.Style.FILL);

        mCircleProgressPaint = new Paint();
        mCircleProgressPaint.setAntiAlias(true);
        mCircleProgressPaint.setDither(true);
        mCircleProgressPaint.setColor(mCircleProgressColor);
        mCircleProgressPaint.setStrokeWidth(mCircleStrokeWidth);
        mCircleProgressPaint.setStyle(Paint.Style.STROKE);
        mCircleProgressPaint.setStrokeJoin(Paint.Join.ROUND);
        mCircleProgressPaint.setStrokeCap(Paint.Cap.BUTT);


        //是否有线性渐变效果
        if (enableShader) {

            mHighligtProgressArcPaint = new Paint();
            mHighligtProgressArcPaint.setAntiAlias(true);
            mHighligtProgressArcPaint.setDither(true);
            mHighligtProgressArcPaint.setColor(mCircleProgressColor);
            mHighligtProgressArcPaint.setStrokeWidth(mCircleStrokeWidth);
            mHighligtProgressArcPaint.setStyle(Paint.Style.STROKE);
            mHighligtProgressArcPaint.setStrokeJoin(Paint.Join.ROUND);


            int[] rainbow1 = {getResources().getColor(R.color.transparent),
                    getResources().getColor(R.color.speed_meter_color_80),

            };

            float[] positions1 = {0.0f, 1.0f};

            Shader shader = new SweepGradient(mCircleWidth, mCircleWidth, rainbow1, positions1);
            Matrix matrix = new Matrix();
            matrix.setRotate(135);
            shader.setLocalMatrix(matrix);

            Log.d(TAG, "initPaints() called with " + "mprogressDegree" + mProgressDegrees);
            mCircleProgressPaint.setShader(shader);


        }


        mCircleProgressGlowPaint = new Paint();
        mCircleProgressGlowPaint.set(mCircleProgressPaint);
        mCircleProgressGlowPaint.setMaskFilter(new BlurMaskFilter((5f * DPTOPX_SCALE), BlurMaskFilter.Blur.NORMAL));

        mPointerPaint = new Paint();
        mPointerPaint.setAntiAlias(true);
        mPointerPaint.setDither(true);
        mPointerPaint.setStyle(Paint.Style.FILL);
        mPointerPaint.setColor(mPointerColor);
        mPointerPaint.setStrokeWidth(mPointerRadius);

        mPointerHaloPaint = new Paint();
        mPointerHaloPaint.set(mPointerPaint);
        mPointerHaloPaint.setColor(mPointerHaloColor);
        mPointerHaloPaint.setAlpha(mPointerAlpha);
        mPointerHaloPaint.setStrokeWidth(mPointerRadius + mPointerHaloWidth);

        mPointerHaloBorderPaint = new Paint();
        mPointerHaloBorderPaint.set(mPointerPaint);
        mPointerHaloBorderPaint.setStrokeWidth(mPointerHaloBorderWidth);
        mPointerHaloBorderPaint.setStyle(Paint.Style.STROKE);


        if (enableProgressText) {
            // Set up a default TextPaint object
            mProgressTextPaint = new TextPaint();
            mProgressTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
            mProgressTextPaint.setTextAlign(Paint.Align.LEFT);

            invalidateTextPaintAndMeasurements();
        }


    }

    /**
     * Calculates the total degrees between mStartAngle and mEndAngle, and sets mTotalCircleDegrees
     * to this value.
     */
    protected void calculateTotalDegrees() {
        mTotalCircleDegrees = (360f - (mStartAngle - mEndAngle)) % 360f; // Length of the entire circle/arc
        if (mTotalCircleDegrees <= 0f) {
            mTotalCircleDegrees = 360f;
        }
    }

    /**
     * Calculate the degrees that the progress represents. Also called the sweep angle.
     * Sets mProgressDegrees to that value.
     */
    protected void calculateProgressDegrees() {
        mProgressDegrees = mPointerPosition - mStartAngle; // Verified
        mProgressDegrees = (mProgressDegrees < 0 ? 360f + mProgressDegrees : mProgressDegrees); // Verified
        Log.d(TAG, "calculateProgressDegrees mProgressDegrees" + mProgressDegrees);
        invalidateProgressPaint();
    }

    /**
     * Calculate the pointer position (and the end of the progress arc) in degrees.
     * Sets mPointerPosition to that value.
     */
    protected void calculatePointerAngle() {
        float progressPercent = ((float) mProgress / (float) mMax);
        mPointerPosition = (progressPercent * mTotalCircleDegrees) + mStartAngle;
        mPointerPosition = mPointerPosition % 360f;
    }

    protected void calculatePointerXYPosition() {
        PathMeasure pm = new PathMeasure(mCircleProgressPath, false);
        boolean returnValue = pm.getPosTan(pm.getLength(), mPointerPositionXY, null);
        if (!returnValue) {
            pm = new PathMeasure(mCirclePath, false);
            returnValue = pm.getPosTan(0, mPointerPositionXY, null);
        }
    }

    protected void calculateTextXYPosition() {
        PathMeasure pm = new PathMeasure(mProgressTextPath, false);
        boolean returnValue = pm.getPosTan(pm.getLength(), mProgressTextPositionXY, null);
        if (!returnValue) {
            pm = new PathMeasure(mProgressTextPath, false);
            returnValue = pm.getPosTan(0, mProgressTextPositionXY, null);
        }
    }

    /**
     * Initialize the {@code Path} objects with the appropriate values.
     */
    protected void initPaths() {
        mCirclePath = new Path();
        mCirclePath.addArc(mCircleRectF, mStartAngle, mTotalCircleDegrees);

        mCircleProgressPath = new Path();
        mCircleProgressPath.addArc(mCircleRectF, mStartAngle, mProgressDegrees);


        if (enableShader) {
            mHighligtProgressArcPath = new Path();
            float start = mProgressDegrees * 0.6f + mStartAngle;

            //不能超出仪表刻度

            //mProgressDegrees*0.2f

            mHighligtProgressArcPath.addArc(mCircleRectF, start, mProgressDegrees * 0.4f);//高光百分之二十

            //mHighligtProgressArcPath .addArc(mCircleRectF,mStartAngle+mProgressDegrees-20,20);

            Log.d(TAG, "initPaths() called with " + " mStartAngle " + mStartAngle
                    + ",mProgressDegrees " + mProgressDegrees);

            Log.d(TAG, "initPaths()" + " start with " + start
                    + ", mProgressDegrees " + mProgressDegrees);
        }

        mProgressTextPath = new Path();
        mProgressTextPath.addArc(mProgressTextCircleRectF, mStartAngle, mProgressDegrees);

    }

    /**
     * Initialize the {@code RectF} objects with the appropriate values.
     */
    protected void initRects() {
        mCircleRectF.set(-mCircleWidth, -mCircleHeight, mCircleWidth, mCircleHeight);
        if (enablePoint) {
            mProgressTextCircleRectF.set(-mCircleWidth - mPointerRadius * 2, -mCircleHeight - mPointerRadius * 2, mCircleWidth + mPointerRadius * 2, mCircleHeight + mPointerRadius * 2);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(this.getWidth() / 2, this.getHeight() / 2);
        // canvas.drawPath(mCirclePath, mCirclePaint);
        //canvas.drawPath(mCircleProgressPath, mCircleProgressGlowPaint);
        canvas.drawPath(mCircleProgressPath, mCircleProgressPaint);

        //progressbar高光部分
        if (enableShader) {
            canvas.drawPath(mHighligtProgressArcPath, mHighligtProgressArcPaint);
        }

        canvas.drawPath(mCirclePath, mCircleFillPaint);

        //大于10%，显示字
        if (showTextATLowPercent && enableProgressText) {

            canvas.drawText(mProgressString,
                    mProgressTextPositionXY[0],
                    mProgressTextPositionXY[1] + mPointerRadius,
                    mProgressTextPaint);


        } else {
            if (mProgress > mMax * 0.1 && enableProgressText) {

                canvas.drawText(mProgressString,
                        mProgressTextPositionXY[0] - mPointerRadius * 0.75f,
                        mProgressTextPositionXY[1] - mPointerRadius,
                        mProgressTextPaint);


            }
        }
        if (enablePoint) {
            canvas.drawCircle(mPointerPositionXY[0], mPointerPositionXY[1], mPointerRadius + mPointerHaloWidth, mPointerHaloPaint);
            //canvas.drawCircle(mPointerPositionXY[0], mPointerPositionXY[1], mPointerRadius, mPointerPaint);
            if (mUserIsMovingPointer) {
                canvas.drawCircle(mPointerPositionXY[0], mPointerPositionXY[1], mPointerRadius + mPointerHaloWidth + (mPointerHaloBorderWidth / 2f), mPointerHaloBorderPaint);
            }
        }

    }

    /**
     * Get the progress of the CircularSeekBar.
     *
     * @return The progress of the CircularSeekBar.
     */
    public int getProgress() {
        int progress = Math.round((float) mMax * mProgressDegrees / mTotalCircleDegrees);
        return progress;
    }

    /**
     * Set the progress of the CircularSeekBar.
     * If the progress is the same, then any listener will not receive a onProgressChanged event.
     *
     * @param progress The progress to set the CircularSeekBar to.
     */
    public void setProgress(int progress) {
        if (mProgress != progress) {
            int lastPrpgress = mProgress;
            mProgress = progress;
            if (mOnCircularSeekBarChangeListener != null) {
                mOnCircularSeekBarChangeListener.onProgressChanged(this, progress, false);
            }

            mProgressString = mProgress + "";

            recalculateAll();

            //添加动画
            ObjectAnimator anim = ObjectAnimator.ofInt(this, "mProgress", lastPrpgress, progress);
            anim.setDuration(500);
            anim.addUpdateListener(this);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.start();
            Log.d(TAG, "setProgress() called with " + "progress = [" + progress + "]");
            //invalidate();
        }
    }

    protected void setProgressBasedOnAngle(float angle) {
        mPointerPosition = angle;
        calculateProgressDegrees();
        mProgress = Math.round((float) mMax * mProgressDegrees / mTotalCircleDegrees);
        mProgressString = mProgress + "";
    }

    protected void recalculateAll() {
        calculateTotalDegrees();
        calculatePointerAngle();
        calculateProgressDegrees();

        initRects();

        initPaths();

        calculatePointerXYPosition();
        calculateTextXYPosition();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        if (mMaintainEqualCircle) {
            int min = Math.min(width, height);
            setMeasuredDimension(min, min);
        } else {
            setMeasuredDimension(width, height);
        }

        // Set the circle width and height based on the view for the moment
        mCircleHeight = (float) height / 2f - mCircleStrokeWidth - mPointerRadius - (mPointerHaloBorderWidth * 1.5f);
        mCircleWidth = (float) width / 2f - mCircleStrokeWidth - mPointerRadius - (mPointerHaloBorderWidth * 1.5f);

        if (!enablePoint) {
            // Set the circle width and height based on the view for the moment
//            mCircleHeight = (float) height / 2f - mCircleStrokeWidth ;
//            mCircleWidth = (float) width / 2f - mCircleStrokeWidth;
            mCircleHeight = (float) height / 2f;
            mCircleWidth = (float) width / 2f;

        }

        // If it is not set to use custom
        if (mCustomRadii) {
            // Check to make sure the custom radii are not out of the view. If they are, just use the view values
            if ((mCircleYRadius - mCircleStrokeWidth - mPointerRadius - mPointerHaloBorderWidth) < mCircleHeight) {
                mCircleHeight = mCircleYRadius - mCircleStrokeWidth - mPointerRadius - (mPointerHaloBorderWidth * 1.5f);
            }

            if ((mCircleXRadius - mCircleStrokeWidth - mPointerRadius - mPointerHaloBorderWidth) < mCircleWidth) {
                mCircleWidth = mCircleXRadius - mCircleStrokeWidth - mPointerRadius - (mPointerHaloBorderWidth * 1.5f);
            }

            if (!enablePoint) {
                if ((mCircleYRadius - mCircleStrokeWidth) < mCircleHeight) {
                    mCircleHeight = mCircleYRadius;
                }

                if ((mCircleXRadius - mCircleStrokeWidth) < mCircleWidth) {
                    mCircleWidth = mCircleXRadius;
                }
            }
        }

        if (mMaintainEqualCircle) { // Applies regardless of how the values were determined
            float min = Math.min(mCircleHeight, mCircleWidth);
            mCircleHeight = min;
            mCircleWidth = min;
        }

        recalculateAll();
    }

    /**
     * Get whether the pointer locks at zero and max.
     *
     * @return Boolean value of true if the pointer locks at zero and max, false if it does not.
     */
    public boolean isLockEnabled() {
        return lockEnabled;
    }

    /**
     * Set whether the pointer locks at zero and max or not.
     *
     * @param boolean value. True if the pointer should lock at zero and max, false if it should not.
     */
    public void setLockEnabled(boolean lockEnabled) {
        this.lockEnabled = lockEnabled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isTouchEnabled) {
            return false;
        }

        // Convert coordinates to our internal coordinate system
        float x = event.getX() - getWidth() / 2;
        float y = event.getY() - getHeight() / 2;

        // Get the distance from the center of the circle in terms of x and y
        float distanceX = mCircleRectF.centerX() - x;
        float distanceY = mCircleRectF.centerY() - y;

        // Get the distance from the center of the circle in terms of a radius
        float touchEventRadius = (float) Math.sqrt((Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));

        float minimumTouchTarget = MIN_TOUCH_TARGET_DP * DPTOPX_SCALE; // Convert minimum touch target into px
        float additionalRadius; // Either uses the minimumTouchTarget size or larger if the ring/pointer is larger

        if (mCircleStrokeWidth < minimumTouchTarget) { // If the width is less than the minimumTouchTarget, use the minimumTouchTarget
            additionalRadius = minimumTouchTarget / 2;
        } else {
            additionalRadius = mCircleStrokeWidth / 2; // Otherwise use the width
        }
        float outerRadius = Math.max(mCircleHeight, mCircleWidth) + additionalRadius; // Max outer radius of the circle, including the minimumTouchTarget or wheel width
        float innerRadius = Math.min(mCircleHeight, mCircleWidth) - additionalRadius; // Min inner radius of the circle, including the minimumTouchTarget or wheel width

        if (mPointerRadius < (minimumTouchTarget / 2)) { // If the pointer radius is less than the minimumTouchTarget, use the minimumTouchTarget
            additionalRadius = minimumTouchTarget / 2;
        } else {
            additionalRadius = mPointerRadius; // Otherwise use the radius
        }

        float touchAngle;
        touchAngle = (float) ((Math.atan2(y, x) / Math.PI * 180) % 360); // Verified
        touchAngle = (touchAngle < 0 ? 360 + touchAngle : touchAngle); // Verified

        cwDistanceFromStart = touchAngle - mStartAngle; // Verified
        cwDistanceFromStart = (cwDistanceFromStart < 0 ? 360f + cwDistanceFromStart : cwDistanceFromStart); // Verified
        ccwDistanceFromStart = 360f - cwDistanceFromStart; // Verified

        cwDistanceFromEnd = touchAngle - mEndAngle; // Verified
        cwDistanceFromEnd = (cwDistanceFromEnd < 0 ? 360f + cwDistanceFromEnd : cwDistanceFromEnd); // Verified
        ccwDistanceFromEnd = 360f - cwDistanceFromEnd; // Verified

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // These are only used for ACTION_DOWN for handling if the pointer was the part that was touched
                float pointerRadiusDegrees = (float) ((mPointerRadius * 180) / (Math.PI * Math.max(mCircleHeight, mCircleWidth)));
                cwDistanceFromPointer = touchAngle - mPointerPosition;
                cwDistanceFromPointer = (cwDistanceFromPointer < 0 ? 360f + cwDistanceFromPointer : cwDistanceFromPointer);
                ccwDistanceFromPointer = 360f - cwDistanceFromPointer;
                // This is for if the first touch is on the actual pointer.
                if (((touchEventRadius >= innerRadius) && (touchEventRadius <= outerRadius)) && ((cwDistanceFromPointer <= pointerRadiusDegrees) || (ccwDistanceFromPointer <= pointerRadiusDegrees))) {
                    setProgressBasedOnAngle(mPointerPosition);
                    lastCWDistanceFromStart = cwDistanceFromStart;
                    mIsMovingCW = true;
                    mPointerHaloPaint.setAlpha(mPointerAlphaOnTouch);
                    mPointerHaloPaint.setColor(mPointerHaloColorOnTouch);
                    recalculateAll();
                    invalidate();
                    if (mOnCircularSeekBarChangeListener != null) {
                        mOnCircularSeekBarChangeListener.onStartTrackingTouch(this);
                    }
                    mUserIsMovingPointer = true;
                    lockAtEnd = false;
                    lockAtStart = false;
                } else if (cwDistanceFromStart > mTotalCircleDegrees) { // If the user is touching outside of the start AND end
                    mUserIsMovingPointer = false;
                    return false;
                } else if ((touchEventRadius >= innerRadius) && (touchEventRadius <= outerRadius)) { // If the user is touching near the circle
                    setProgressBasedOnAngle(touchAngle);
                    lastCWDistanceFromStart = cwDistanceFromStart;
                    mIsMovingCW = true;
                    mPointerHaloPaint.setAlpha(mPointerAlphaOnTouch);
                    mPointerHaloPaint.setColor(mPointerHaloColorOnTouch);
                    recalculateAll();
                    invalidate();
                    if (mOnCircularSeekBarChangeListener != null) {
                        mOnCircularSeekBarChangeListener.onStartTrackingTouch(this);
                        mOnCircularSeekBarChangeListener.onProgressChanged(this, mProgress, true);
                    }
                    mUserIsMovingPointer = true;
                    lockAtEnd = false;
                    lockAtStart = false;
                } else { // If the user is not touching near the circle
                    mUserIsMovingPointer = false;
                    return false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mUserIsMovingPointer) {
                    if (lastCWDistanceFromStart < cwDistanceFromStart) {
                        if ((cwDistanceFromStart - lastCWDistanceFromStart) > 180f && !mIsMovingCW) {
                            lockAtStart = true;
                            lockAtEnd = false;
                        } else {
                            mIsMovingCW = true;
                        }
                    } else {
                        if ((lastCWDistanceFromStart - cwDistanceFromStart) > 180f && mIsMovingCW) {
                            lockAtEnd = true;
                            lockAtStart = false;
                        } else {
                            mIsMovingCW = false;
                        }
                    }

                    if (lockAtStart && mIsMovingCW) {
                        lockAtStart = false;
                    }
                    if (lockAtEnd && !mIsMovingCW) {
                        lockAtEnd = false;
                    }
                    if (lockAtStart && !mIsMovingCW && (ccwDistanceFromStart > 90)) {
                        lockAtStart = false;
                    }
                    if (lockAtEnd && mIsMovingCW && (cwDistanceFromEnd > 90)) {
                        lockAtEnd = false;
                    }
                    // Fix for passing the end of a semi-circle quickly
                    if (!lockAtEnd && cwDistanceFromStart > mTotalCircleDegrees && mIsMovingCW && lastCWDistanceFromStart < mTotalCircleDegrees) {
                        lockAtEnd = true;
                    }

                    if (lockAtStart && lockEnabled) {
                        // TODO: Add a check if mProgress is already 0, in which case don't call the listener
                        mProgress = 0;
                        recalculateAll();
                        invalidate();
                        if (mOnCircularSeekBarChangeListener != null) {
                            mOnCircularSeekBarChangeListener.onProgressChanged(this, mProgress, true);
                        }

                    } else if (lockAtEnd && lockEnabled) {
                        mProgress = mMax;
                        mProgressString = mProgress + "";
                        recalculateAll();
                        invalidate();
                        if (mOnCircularSeekBarChangeListener != null) {
                            mOnCircularSeekBarChangeListener.onProgressChanged(this, mProgress, true);
                        }
                    } else if ((mMoveOutsideCircle) || (touchEventRadius <= outerRadius)) {
                        if (!(cwDistanceFromStart > mTotalCircleDegrees)) {
                            setProgressBasedOnAngle(touchAngle);
                        }
                        recalculateAll();
                        invalidate();
                        if (mOnCircularSeekBarChangeListener != null) {
                            mOnCircularSeekBarChangeListener.onProgressChanged(this, mProgress, true);
                        }
                    } else {
                        break;
                    }

                    lastCWDistanceFromStart = cwDistanceFromStart;
                } else {
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                mPointerHaloPaint.setAlpha(mPointerAlpha);
                mPointerHaloPaint.setColor(mPointerHaloColor);
                if (mUserIsMovingPointer) {
                    mUserIsMovingPointer = false;
                    invalidate();
                    if (mOnCircularSeekBarChangeListener != null) {
                        mOnCircularSeekBarChangeListener.onStopTrackingTouch(this);
                    }
                } else {
                    return false;
                }
                break;
            case MotionEvent.ACTION_CANCEL: // Used when the parent view intercepts touches for things like scrolling
                mPointerHaloPaint.setAlpha(mPointerAlpha);
                mPointerHaloPaint.setColor(mPointerHaloColor);
                mUserIsMovingPointer = false;
                invalidate();
                break;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }

        return true;
    }

    protected void init(AttributeSet attrs, int defStyle) {
        final TypedArray attrArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircularSeekBar, defStyle, 0);

        initAttributes(attrArray);

        attrArray.recycle();

        initPaints();
    }

    public CircularSeekBar(Context context) {
        super(context);
        init(null, 0);
    }

    public CircularSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CircularSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        Bundle state = new Bundle();
        state.putParcelable("PARENT", superState);
        state.putInt("MAX", mMax);
        state.putInt("PROGRESS", mProgress);
        state.putInt("mCircleColor", mCircleColor);
        state.putInt("mCircleProgressColor", mCircleProgressColor);
        state.putInt("mPointerColor", mPointerColor);
        state.putInt("mPointerHaloColor", mPointerHaloColor);
        state.putInt("mPointerHaloColorOnTouch", mPointerHaloColorOnTouch);
        state.putInt("mPointerAlpha", mPointerAlpha);
        state.putInt("mPointerAlphaOnTouch", mPointerAlphaOnTouch);
        state.putBoolean("lockEnabled", lockEnabled);
        state.putBoolean("isTouchEnabled", isTouchEnabled);

        return state;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Bundle savedState = (Bundle) state;

        Parcelable superState = savedState.getParcelable("PARENT");
        super.onRestoreInstanceState(superState);

        mMax = savedState.getInt("MAX");
        mProgress = savedState.getInt("PROGRESS");
        mCircleColor = savedState.getInt("mCircleColor");
        mCircleProgressColor = savedState.getInt("mCircleProgressColor");
        mPointerColor = savedState.getInt("mPointerColor");
        mPointerHaloColor = savedState.getInt("mPointerHaloColor");
        mPointerHaloColorOnTouch = savedState.getInt("mPointerHaloColorOnTouch");
        mPointerAlpha = savedState.getInt("mPointerAlpha");
        mPointerAlphaOnTouch = savedState.getInt("mPointerAlphaOnTouch");
        lockEnabled = savedState.getBoolean("lockEnabled");
        isTouchEnabled = savedState.getBoolean("isTouchEnabled");

        initPaints();

        recalculateAll();
    }

    public void setOnSeekBarChangeListener(OnCircularSeekBarChangeListener l) {
        mOnCircularSeekBarChangeListener = l;
    }

    /**
     * Listener for the CircularSeekBar. Implements the same methods as the normal OnSeekBarChangeListener.
     */
    public interface OnCircularSeekBarChangeListener {

        public abstract void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser);

        public abstract void onStopTrackingTouch(CircularSeekBar seekBar);

        public abstract void onStartTrackingTouch(CircularSeekBar seekBar);
    }

    /**
     * Sets the circle color.
     *
     * @param color the color of the circle
     */
    public void setCircleColor(int color) {
        mCircleColor = color;
        mCirclePaint.setColor(mCircleColor);
        invalidate();
    }

    /**
     * Gets the circle color.
     *
     * @return An integer color value for the circle
     */
    public int getCircleColor() {
        return mCircleColor;
    }

    /**
     * Sets the circle progress color.
     *
     * @param color the color of the circle progress
     */
    public void setCircleProgressColor(int color) {
        mCircleProgressColor = color;
        mCircleProgressPaint.setColor(mCircleProgressColor);
        invalidate();
    }

    /**
     * Gets the circle progress color.
     *
     * @return An integer color value for the circle progress
     */
    public int getCircleProgressColor() {
        return mCircleProgressColor;
    }

    /**
     * Sets the pointer color.
     *
     * @param color the color of the pointer
     */
    public void setPointerColor(int color) {
        mPointerColor = color;
        mPointerPaint.setColor(mPointerColor);
        invalidate();
    }

    /**
     * Gets the pointer color.
     *
     * @return An integer color value for the pointer
     */
    public int getPointerColor() {
        return mPointerColor;
    }

    /**
     * Sets the pointer halo color.
     *
     * @param color the color of the pointer halo
     */
    public void setPointerHaloColor(int color) {
        mPointerHaloColor = color;
        mPointerHaloPaint.setColor(mPointerHaloColor);
        invalidate();
    }

    /**
     * Gets the pointer halo color.
     *
     * @return An integer color value for the pointer halo
     */
    public int getPointerHaloColor() {
        return mPointerHaloColor;
    }

    /**
     * Sets the pointer alpha.
     *
     * @param alpha the alpha of the pointer
     */
    public void setPointerAlpha(int alpha) {
        if (alpha >= 0 && alpha <= 255) {
            mPointerAlpha = alpha;
            mPointerHaloPaint.setAlpha(mPointerAlpha);
            invalidate();
        }
    }

    /**
     * Gets the pointer alpha value.
     *
     * @return An integer alpha value for the pointer (0..255)
     */
    public int getPointerAlpha() {
        return mPointerAlpha;
    }

    /**
     * Sets the pointer alpha when touched.
     *
     * @param alpha the alpha of the pointer (0..255) when touched
     */
    public void setPointerAlphaOnTouch(int alpha) {
        if (alpha >= 0 && alpha <= 255) {
            mPointerAlphaOnTouch = alpha;
        }
    }

    /**
     * Gets the pointer alpha value when touched.
     *
     * @return An integer alpha value for the pointer (0..255) when touched
     */
    public int getPointerAlphaOnTouch() {
        return mPointerAlphaOnTouch;
    }

    /**
     * Sets the circle fill color.
     *
     * @param color the color of the circle fill
     */
    public void setCircleFillColor(int color) {
        mCircleFillColor = color;
        mCircleFillPaint.setColor(mCircleFillColor);
        invalidate();
    }

    /**
     * Gets the circle fill color.
     *
     * @return An integer color value for the circle fill
     */
    public int getCircleFillColor() {
        return mCircleFillColor;
    }

    /**
     * Set the max of the CircularSeekBar.
     * If the new max is less than the current progress, then the progress will be set to zero.
     * If the progress is changed as a result, then any listener will receive a onProgressChanged event.
     *
     * @param max The new max for the CircularSeekBar.
     */
    public void setMax(int max) {
        if (!(max <= 0)) { // Check to make sure it's greater than zero
            if (max <= mProgress) {
                mProgress = 0; // If the new max is less than current progress, set progress to zero
                if (mOnCircularSeekBarChangeListener != null) {
                    mOnCircularSeekBarChangeListener.onProgressChanged(this, mProgress, false);
                }
            }
            mMax = max;

            recalculateAll();
            invalidate();
        }
    }

    /**
     * Get the current max of the CircularSeekBar.
     *
     * @return Synchronized integer value of the max.
     */
    public synchronized int getMax() {
        return mMax;
    }


    public float getCcwDistanceFromEnd() {
        return ccwDistanceFromEnd;
    }

    public void setCcwDistanceFromEnd(float ccwDistanceFromEnd) {
        this.ccwDistanceFromEnd = ccwDistanceFromEnd;
    }

    public int getmProgressTextColor() {
        return mProgressTextColor;
    }

    public void setmProgressTextColor(int mProgressTextColor) {
        invalidateTextPaintAndMeasurements();
        this.mProgressTextColor = mProgressTextColor;
    }

    public int getmProgressTextDimension() {
        return mProgressTextDimension;
    }

    public void setmProgressTextDimension(int mProgressTextDimension) {
        invalidateTextPaintAndMeasurements();
        this.mProgressTextDimension = mProgressTextDimension;
    }

    /**
     * Set whether user touch input is accepted or ignored.
     *
     * @param boolean value. True if user touch input is to be accepted, false if user touch input is to be ignored.
     */
    public void setIsTouchEnabled(boolean isTouchEnabled) {
        this.isTouchEnabled = isTouchEnabled;
    }

    /**
     * Get whether user touch input is accepted.
     *
     * @return Boolean value of true if user touch input is accepted, false if user touch input is ignored.
     */
    public boolean getIsTouchEnabled() {
        return isTouchEnabled;
    }


    private void invalidateTextPaintAndMeasurements() {

        mProgressString = mProgress + "";

        if (mProgressString != null) {


            mProgressTextPaint.setTextSize(mProgressTextDimension);
            mProgressTextPaint.setColor(mProgressTextColor);
            mProgressTextWidth = mProgressTextPaint.measureText(mProgressString);

            Paint.FontMetrics fontMetrics = mProgressTextPaint.getFontMetrics();
            mProgressTextHeight = fontMetrics.bottom;//// TODO: 15/10/22 用字的height和width调整画的位置

        }


    }

    private void invalidateProgressPaint() {
        if (enableShader) {

            int[] rainbow = {getResources().getColor(R.color.transparent),

                    getResources().getColor(R.color.speed_meter_color_70),
                    getResources().getColor(R.color.transparent)

            };

            float[] positions = {0.0f, mProgressDegrees / 360.0f, 1.0f};

            Shader shader = new SweepGradient(0, 0, rainbow, positions);

//            Log.d(TAG, "invalidateProgressPaint() called with "
//                    + "mCircleWidth,"+mCircleWidth+"mCircleHeight "+mCircleHeight+"mProgressDegrees,"
//            +mProgressDegrees +" "+mProgressDegrees/360);
            Matrix matrix = new Matrix();
            matrix.setRotate(135);
            shader.setLocalMatrix(matrix);
            mCircleProgressPaint.setShader(shader);


            //高光部分
            int[] rainbowHilight = {getResources().getColor(R.color.transparent),

                    getResources().getColor(R.color.speed_meter_color_40),
                    getResources().getColor(R.color.transparent)
            };
            float[] positionsHighlight = {0.0f, (mProgressDegrees * 0.4f) / 360.0f, 1.0f};//高光百分之六十
            //Log.d(TAG, "invalidateProgressPaint() called with mProgressDegrees" + mProgressDegrees*0.4f/360.0f+" ,start "+(135 + mProgressDegrees * 0.6f));
            Shader highLightShader = new SweepGradient(0, 0, rainbowHilight, positionsHighlight);
            Matrix hlMatrix = new Matrix();
            matrix.setRotate(135 + mProgressDegrees * 0.6f);
            highLightShader.setLocalMatrix(hlMatrix);
            //highLightShader.setLocalMatrix(matrix);
            mHighligtProgressArcPaint.setShader(highLightShader);
        }
    }

    /**
     * <p>Notifies the occurrence of another frame of the animation.</p>
     *
     * @param animation The animation which was repeated.
     */
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        Log.d(TAG, "onAnimationUpdate() called with " + "mProgress = [" + mProgress + "]");
        recalculateAll();
        invalidate();
    }

    public void setMProgress(int mProgress) {
        Log.d(TAG, "setmProgress() called with " + "mProgress = [" + mProgress + "]");
        this.mProgress = mProgress;
    }

    public int getMProgress() {
        return mProgress;
    }
}
