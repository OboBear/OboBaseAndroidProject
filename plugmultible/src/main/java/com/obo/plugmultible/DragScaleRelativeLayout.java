package com.obo.plugmultible;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by obo on 16/1/10.
 */
public class DragScaleRelativeLayout extends RelativeLayout{

    public final static String TAG = DragScaleRelativeLayout.class.getCanonicalName();

    DragScaleImpl dragScale;

    public DragScaleRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dragScale = new DragScaleImpl();
        setOnTouchListener(dragScale);
    }

    public DragScaleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        dragScale = new DragScaleImpl();
        setOnTouchListener(dragScale);
    }

    public DragScaleRelativeLayout(Context context) {
        super(context);
        dragScale = new DragScaleImpl();
        setOnTouchListener(dragScale);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dragScale.draw(this,canvas);
    }
}