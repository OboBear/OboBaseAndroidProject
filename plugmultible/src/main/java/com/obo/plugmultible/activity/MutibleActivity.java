package com.obo.plugmultible.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.obo.plugmultible.view.DragScaleImpl;
import com.obo.plugmultible.view.DragScaleRelativeLayout;
import com.obo.plugmultible.R;
import com.obo.plugmultible.utils.ScreenUtil;
import com.obo.plugmultible.utils.UtilColor;

public class MutibleActivity extends AppCompatActivity implements View.OnClickListener , DragScaleImpl.DragScaleDelegate {
    public final String TAG = MutibleActivity.class.getSimpleName();
//    RelativeLayout layout;
    RelativeLayout root_layout;
    View coverView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mutible);
//        layout = (RelativeLayout) findViewById(R.id.layout);
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        coverView = findViewById(R.id.coverView);
        coverView.setVisibility(View.INVISIBLE);
    }

    int buttonId = 1;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_button:

                Point screenSize = ScreenUtil.getScreenSize(this);
                DragScaleRelativeLayout button = new DragScaleRelativeLayout(this);
                button.setId(buttonId++);
                button.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_UP);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 200);
                layoutParams.setMargins(screenSize.x / 2 - 100, screenSize.y / 2 - 100, 10000, 10000);
                button.setLayoutParams(layoutParams);
                button.setClickable(true);
                root_layout.addView(button);

                DragScaleImpl dragScale = new DragScaleImpl(button);
                dragScale.dragScaleDelegate = this;

                break;
        }
    }
    ////////////
    //DragScaleImpl
    @Override
    public void longPress(View v) {
        Log.i(TAG, "longPress");
        coverView.setVisibility(View.VISIBLE);
        root_layout.bringChildToFront(coverView);
        root_layout.bringChildToFront(v);
    }

    @Override
    public void upPress(View v) {
        Log.i(TAG,"upPress");
        coverView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void doubleClick(View v) {
        Log.i(TAG,"doubleClick");


    }
}
