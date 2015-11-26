package com.obo.mydemos.reverse;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.obo.activity.R;

public class ReverseActivity extends AppCompatActivity {

    public final static String ACTION = "com.obo.activity.intent.action.ReverseActivity";

    private TextView textView2;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


//        if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
//        {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
//        }


        textView2 = (TextView) findViewById(R.id.textView2);

        layout = (LinearLayout) findViewById(R.id.layout);
//        // 计算中心点
//        final float centerX = textView2.getWidth() / 2.0f;
//        final float centerY = textView2.getHeight() / 2.0f;
//
//        final Rotate3dAnimation rotation = new Rotate3dAnimation(0, 180,
//                50, 0, 0, true);
//        rotation.setDuration(500);
//        rotation.setFillAfter(true);
//        rotation.setInterpolator(new AccelerateInterpolator());
//// 设置监听
////        rotation.setAnimationListener(new DisplayNextView());
//        layout.startAnimation(rotation);
    }

    public void onClick(View view)
    {
        rotate();
    }
    private void rotate()
    {
// 计算中心点
        final float centerX = layout.getWidth() / 2.0f;
        final float centerY = layout.getHeight() / 2.0f;

        final Rotate3dAnimation rotation = new Rotate3dAnimation(0, 180,
                centerX, centerY, 0, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
// 设置监听
//        rotation.setAnimationListener(new DisplayNextView());
        layout.startAnimation(rotation);
    }
}
