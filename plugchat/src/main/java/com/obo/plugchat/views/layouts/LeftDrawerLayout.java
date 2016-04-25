package com.obo.plugchat.views.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.obo.plugchat.R;

/**
 * Created by obo on 16/4/25.
 * Email:obo1993@gmail.com
 */
public class LeftDrawerLayout extends FrameLayout {

    boolean mIsShow = false;
    View mLeftView;
    View rightView;

    public LeftDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mLeftView = findViewById(R.id.left_drawer);
        rightView = findViewById(R.id.right_content);
    }


    /**
     * Change the show status of left drawer. It will do something if the show status is different
     * @param isShow true to show the left drawer , false otherwise. Default value is false.
     */
    public void setLeftDrawerShowStatus(boolean isShow) {
        if (mIsShow != isShow) {
            mIsShow = isShow;

            if (mIsShow) {

            }
        }
     }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return super.onInterceptHoverEvent(event);
    }

}
