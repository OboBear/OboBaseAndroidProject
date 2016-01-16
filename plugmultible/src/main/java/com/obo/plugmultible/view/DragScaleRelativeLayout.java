package com.obo.plugmultible.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.utils.UtilDefines;

/**
 * Created by obo on 16/1/10.
 */
public class DragScaleRelativeLayout extends RelativeLayout implements DragScaleController.DragScaleViewDelegate {

    public static final String TAG = DragScaleRelativeLayout.class.getCanonicalName();

    public static final int viewType = UtilDefines.TYPE_RELATIVELAYOUT;
    //
    DragScaleController dragScale = null;
    //viewModel
    private ViewModel viewModel;

    public DragScaleRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DragScaleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragScaleRelativeLayout(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (dragScale != null) {
            dragScale.draw(this, canvas);
        }
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);

//        RelativeLayout.LayoutParams relativeLayoutParams = (LayoutParams) params;
//        viewModel.getLeft().setAbsoluteValue(relativeLayoutParams.leftMargin);
//        viewModel.getTop().setAbsoluteValue(relativeLayoutParams.topMargin);
//        viewModel.getWidth().setAbsoluteValue(relativeLayoutParams.width);
//        viewModel.getHeight().setAbsoluteValue(relativeLayoutParams.height);
    }


    /////////////////
    //DragScaleViewDelegate

    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public DragScaleController getDragScaleImpl() {
        return dragScale;
    }

    @Override
    public void setDragScale(DragScaleController dragScale) {
        this.dragScale = dragScale;
        setOnTouchListener(dragScale);
        setOnLongClickListener(dragScale);
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    ////////////
    //TODO 必须调用的方法
    /**
     *
     */
//    public ViewModel init() {
//        viewModel = new ViewModel();
//        viewModel.setViewType(viewType);
//        viewModel.setViewId(getId());
//
//        return viewModel;
//    }


}