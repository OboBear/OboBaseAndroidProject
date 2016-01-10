package com.obo.plugmultible;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by obo on 16/1/10.
 */
public class DragScaleImpl implements View.OnTouchListener{

    public final static String TAG = DragScaleRelativeLayout.class.getCanonicalName();

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

    public void draw(View view, Canvas canvas) {

        paint.setColor(Color.RED);
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(offset, offset, view.getWidth() - offset, view.getHeight()
                - offset, paint);
        Log.i(TAG, "onDraw");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(TAG,"onTouch");
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            oriLeft = v.getLeft();
            oriRight = v.getRight();
            oriTop = v.getTop();
            oriBottom = v.getBottom();
            lastY = (int) event.getRawY();
            lastX = (int) event.getRawX();
            dragDirection = getDirection(v, (int) event.getX(),
                    (int) event.getY());
            v.setBackgroundColor(UtilColor.COLOR_TOUCH_DOWN_VIEW);
        }

        // 处理拖动事件
        delDrag(v, event, action);
        v.invalidate();
        return false;
    }

    protected void delDrag(View v, MotionEvent event, int action) {
        Log.i(TAG,"drag");
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
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
            case MotionEvent.ACTION_UP:
                dragDirection = 0;

                int left = v.getLeft();
                int top = v.getTop();

                //实际尺寸赋值
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams.width = v.getRight() - v.getLeft();
                layoutParams.height = v.getBottom() - v.getTop();
                layoutParams.setMargins(left,top,10000,10000);
                v.setLayoutParams(layoutParams);
                v.setBackgroundColor(UtilColor.COLOR_TOUCH_UP_VIEW);

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

//
//    public int getCutWidth() {
//        return getWidth() - 2 * offset;
//    }
//
//
//    public int getCutHeight() {
//        return getHeight() - 2 * offset;
//    }

}
