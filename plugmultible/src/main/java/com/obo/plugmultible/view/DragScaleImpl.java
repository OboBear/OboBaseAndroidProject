package com.obo.plugmultible.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.utils.UtilColor;

/**
 * Created by obo on 16/1/10.
 */
public class DragScaleImpl implements View.OnTouchListener, View.OnLongClickListener {

    public final static String TAG = DragScaleRelativeLayout.class.getCanonicalName();
    // 界面类型
    int viewType;

    protected int lastX;
    protected int lastY;
    private int oriLeft;
    private int oriRight;
    private int oriTop;
    private int oriBottom;
    private int dragDirection;
    private static final int TOP = 0x15;
    private static final int LEFT = 0x16;
    private static final int BOTTOM = 0x17;
    private static final int RIGHT = 0x18;
    private static final int LEFT_TOP = 0x11;
    private static final int RIGHT_TOP = 0x12;
    private static final int LEFT_BOTTOM = 0x13;
    private static final int RIGHT_BOTTOM = 0x14;
    private static final int CENTER = 0x19;

    private static final int MIN_WIDTH = 50;
    private static final int MIN_HEIGHT = 50;
    private int offset = 10;

    protected Paint paint = new Paint();

    //能否拖动
    boolean canMove = false;

    //拖动代理
    public DragScaleDelegate dragScaleDelegate = null;

    ViewModel viewModel;

    public DragScaleImpl(DragScaleViewDelegate dragScaleViewDelegate ) {
        this.viewType = dragScaleViewDelegate.getViewType();
        dragScaleViewDelegate.setDragScale(this);
    }

    public void draw(View view, Canvas canvas) {

        if (canMove) {
            paint.setColor(UtilColor.COLOR_LINE_TOUCH_CANMODIFY);
        } else {
            paint.setColor(UtilColor.COLOR_LINE_TOUCH_CANNOTMODIFY);
        }

        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(4, 4, view.getWidth() - 4, view.getHeight() - 4
                , paint);

        Log.i(TAG, "onDraw");
    }


    long lastClick = 0;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(TAG, "onTouch");

        int action = event.getAction();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            {
                if (System.currentTimeMillis() - lastClick < 800) {
                    if (dragScaleDelegate != null)
                    {
                        dragScaleDelegate.doubleClick(v);

                    }
                    return true;
                }
                lastClick = System.currentTimeMillis();

                oriLeft = v.getLeft();
                oriRight = v.getRight();
                oriTop = v.getTop();
                oriBottom = v.getBottom();
                lastY = (int) event.getRawY();
                lastX = (int) event.getRawX();
                dragDirection = getDirection(v, (int) event.getX(),
                        (int) event.getY());
                v.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_DOWN);
            }
                break;
            case MotionEvent.ACTION_UP:
                dragDirection = 0;

                int left = v.getLeft();
                int top = v.getTop();

                //实际尺寸赋值
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams.width = v.getRight() - v.getLeft();
                layoutParams.height = v.getBottom() - v.getTop();
                layoutParams.setMargins(left, top, 10000, 10000);
                v.setLayoutParams(layoutParams);
                v.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_UP);
                canMove = false;
                if (dragScaleDelegate != null) {
                    dragScaleDelegate.upPress(v);
                }
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG,"cancel");
                break;
        }
        // 处理拖动事件
        delDrag(v, event, action);
        v.invalidate();
        return false;
    }

    protected void delDrag(View v, MotionEvent event, int action) {
        Log.i(TAG, "drag");
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
                if (canMove)
                    switch (dragDirection) {
                        case LEFT: // 左边缘
                            left(v, dx);
                            break;
                        case RIGHT: // 右边缘
                            right(v, dx);
                            break;
                        case BOTTOM: // 下边缘
                            bottom(v, dy);
                            break;
                        case TOP: // 上边缘
                            top(v, dy);
                            break;
                        case CENTER: // 点击中心-->>移动
                            center(v, dx, dy);
                            break;
                        case LEFT_BOTTOM: // 左下
                            left(v, dx);
                            bottom(v, dy);
                            break;
                        case LEFT_TOP: // 左上
                            left(v, dx);
                            top(v, dy);
                            break;
                        case RIGHT_BOTTOM: // 右下
                            right(v, dx);
                            bottom(v, dy);
                            break;
                        case RIGHT_TOP: // 右上
                            right(v, dx);
                            top(v, dy);
                            break;
                    }
                if (dragDirection != CENTER) {
                    v.layout(oriLeft, oriTop, oriRight, oriBottom);
                }
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
        }
    }

    private void center(View v, int dx, int dy) {
        int left = v.getLeft() + dx;
        int top = v.getTop() + dy;
        int right = v.getRight() + dx;
        int bottom = v.getBottom() + dy;
        v.layout(left, top, right, bottom);
    }

    private void top(View v, int dy) {
        oriTop += dy;
        if (oriTop < -offset) {
            oriTop = -offset;
        }
        if (oriBottom - oriTop - 2 * offset < MIN_HEIGHT) {
            oriTop = oriBottom - 2 * offset - MIN_HEIGHT;
        }
    }

    private void bottom(View v, int dy) {
        oriBottom += dy;
        if (oriBottom - oriTop - 2 * offset < MIN_HEIGHT) {
            oriBottom = oriTop + 2 * offset + MIN_HEIGHT;
        }
    }

    private void right(View v, int dx) {
        oriRight += dx;
        if (oriRight - oriLeft - 2 * offset < MIN_WIDTH) {
            oriRight = oriLeft + 2 * offset + MIN_WIDTH;
        }
    }

    private void left(View v, int dx) {
        oriLeft += dx;
        if (oriLeft < -offset) {
            oriLeft = -offset;
        }
        if (oriRight - oriLeft - 2 * offset < MIN_WIDTH) {
            oriLeft = oriRight - 2 * offset - MIN_WIDTH;
        }
    }

    protected int getDirection(View v, int x, int y) {
        int left = v.getLeft();
        int right = v.getRight();
        int bottom = v.getBottom();
        int top = v.getTop();
        if (x < 40 && y < 40) {
            return LEFT_TOP;
        }
        if (y < 40 && right - left - x < 40) {
            return RIGHT_TOP;
        }
        if (x < 40 && bottom - top - y < 40) {
            return LEFT_BOTTOM;
        }
        if (right - left - x < 40 && bottom - top - y < 40) {
            return RIGHT_BOTTOM;
        }
        if (x < 40) {
            return LEFT;
        }
        if (y < 40) {
            return TOP;
        }
        if (right - left - x < 40) {
            return RIGHT;
        }
        if (bottom - top - y < 40) {
            return BOTTOM;
        }
        return CENTER;
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

    //对外部使用
    public interface DragScaleDelegate {

        public void longPress(View v);
        public void upPress(View v);
        public void doubleClick(View v);
    }

    //对DragScalView使用
    public interface DragScaleViewDelegate {
        public int getViewType();
        public void setDragScale(DragScaleImpl dragScale);
        public DragScaleImpl getDragScaleImpl();
        public ViewModel getViewModel();
    }

}
