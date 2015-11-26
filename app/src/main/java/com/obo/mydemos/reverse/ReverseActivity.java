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

        textView2 = (TextView) findViewById(R.id.textView2);

        layout = (LinearLayout) findViewById(R.id.layout);

    }

    public void onClick(View view) {
        rotate();
    }

    int i = 0;

    public void onClick2(View view) {
        textView2.setText("修改：" + (i++));
    }

    private void rotate() {
        // 计算中心点
        final float centerX = layout.getWidth() / 2.0f;
        final float centerY = layout.getHeight() / 2.0f;
        final Rotate3dAnimation rotation = new Rotate3dAnimation(0, 180,
                centerX, centerY, 0, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        // 设置监听
        layout.startAnimation(rotation);
    }
}
