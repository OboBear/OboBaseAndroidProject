package com.obo.plugmultible.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.utils.UtilDefines;

/**
 * Created by obo on 16/1/10.
 */
public class DragScaleRelativeLayout extends RelativeLayout implements DragScaleImpl.DragScaleViewDelegate {

    public static final String TAG = DragScaleRelativeLayout.class.getCanonicalName();

    public static final int viewType = UtilDefines.TYPE_RELATIVELAYOUT;
    //
    DragScaleImpl dragScale = null;
    //viewModel
    ViewModel viewModel;

    public DragScaleRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DragScaleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragScaleRelativeLayout(Context context) {
        super(context);
    }

    ////////////
    //TODO 必须调用的方法
    /**
     *
     */
    public ViewModel init() {
        viewModel = new ViewModel();
        viewModel.setViewType(viewType);
        viewModel.setId(getId());

        return viewModel;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (dragScale != null) {
            dragScale.draw(this, canvas);
        }

    }


    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public DragScaleImpl getDragScaleImpl() {
        return dragScale;
    }

    @Override
    public void setDragScale(DragScaleImpl dragScale) {
        this.dragScale = dragScale;
        setOnTouchListener(dragScale);
        setOnLongClickListener(dragScale);
    }

    @Override
    public ViewModel getViewModel() {
        return null;
    }
}