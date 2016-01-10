package com.obo.plugmultible;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by obo on 16/1/10.
 */
public class DragScaleRelativeLayout extends RelativeLayout{

    public static final String TAG = DragScaleRelativeLayout.class.getCanonicalName();

    public static final int viewType = UtilDefines.TYPE_RELATIVELAYOUT;

    DragScaleImpl dragScale = null;

    public DragScaleRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dragScale = new DragScaleImpl(viewType);
        setOnTouchListener(dragScale);
        setOnLongClickListener(dragScale);
    }

    public DragScaleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        dragScale = new DragScaleImpl(viewType);
        setOnTouchListener(dragScale);
        setOnLongClickListener(dragScale);
    }

    public DragScaleRelativeLayout(Context context) {
        super(context);
        dragScale = new DragScaleImpl(viewType);
        setOnTouchListener(dragScale);
        setOnLongClickListener(dragScale);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dragScale.draw(this, canvas);
    }

    public void setDragScale(DragScaleImpl dragScale) {
    }
}