package com.obo.plugmultible.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.utils.UtilColor;

/**
 * Created by obo on 16/1/10.
 */
public class MutibleViewController extends MutibleViewControllerBaseTouch implements  View.OnLongClickListener {

    public final static String TAG = DragScaleRelativeLayout.class.getCanonicalName();

    protected Paint paint = new Paint();

    public MutibleViewController() {}

    /**
     * 根据view的实际尺寸等更新viewModel状态
     */
    public void updateViewModel() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dragScaleViewDelegate.getLayoutParams();
        this.viewModel.setViewType(dragScaleViewDelegate.getViewType());
        this.viewModel.setViewId(dragScaleViewDelegate.getId());
        this.viewModel.getLeft().setAbsoluteValue(layoutParams.leftMargin);
        this.viewModel.getTop().setAbsoluteValue(layoutParams.topMargin);
        this.viewModel.getWidth().setAbsoluteValue(layoutParams.width);
        this.viewModel.getHeight().setAbsoluteValue(layoutParams.height);
    }

    public void draw(View view, Canvas canvas) {

        //选中状态，添加边框
        if (currentSelectId == viewModel.getViewId()) {

            if (canMove) {
                paint.setColor(UtilColor.COLOR_LINE_TOUCH_CANMODIFY);
            } else {
                paint.setColor(UtilColor.COLOR_LINE_TOUCH_CANNOTMODIFY);
            }

            paint.setStrokeWidth(8.0f);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawRect(4, 4, view.getWidth() - 4, view.getHeight() - 4
                    , paint);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        v.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_CANMODIFY);
        canMove = true;
        if (dragScaleDelegate != null) {
            dragScaleDelegate.longPress(v);
        }
        return false;
    }

    public void setViewModel(ViewModel viewModel) {

        this.viewModel = viewModel;

        if (dragScaleViewDelegate != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dragScaleViewDelegate.getLayoutParams();
            layoutParams.leftMargin = (int) viewModel.getLeft().getAbsoluteValue();
            layoutParams.topMargin = (int) viewModel.getTop().getAbsoluteValue();
            layoutParams.width = (int) viewModel.getWidth().getAbsoluteValue();
            layoutParams.height = (int) viewModel.getHeight().getAbsoluteValue();
            dragScaleViewDelegate.setLayoutParams(layoutParams);

            ((View)dragScaleViewDelegate).setAlpha((float) viewModel.getAlpha().getPercentValue());
        }
    }

    public ViewModel getViewModel() {
        Log.i(TAG,"MOdel.isPercent"+viewModel.getLeft().isPercent());
        Log.i(TAG, "MOdel.isPercent" + viewModel.getTop().isPercent());
        return this.viewModel;
    }

    public void setDragScaleViewDelegate(DragScaleViewDelegate dragScaleViewDelegate) {
        this.dragScaleViewDelegate = dragScaleViewDelegate;
        this.dragScaleViewDelegate.setDragScale(this);
    }



}
