package com.example.obo.animationloading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimateView animateView1 = (AnimateView) findViewById(R.id.view_1);
        final AnimateView animateView2 = (AnimateView) findViewById(R.id.view_2);
        final AnimateView animateView3 = (AnimateView) findViewById(R.id.view_3);

        animateView1.setData(6, 60);
        animateView2.setData(2, 70);
        animateView3.setData(2, 80);

        animateView1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, animateView1.getWidth() / 2, animateView1.getHeight() / 2);
                rotateAnimation.setDuration(1500);
                rotateAnimation.setRepeatCount(-1);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                animateView1.startAnimation(rotateAnimation);

                RotateAnimation rotateAnimation2 = new RotateAnimation(360, 0, animateView2.getWidth() / 2, animateView2.getHeight() / 2);
                rotateAnimation2.setDuration(2000);
                rotateAnimation2.setRepeatCount(-1);
                rotateAnimation2.setInterpolator(new LinearInterpolator());
                animateView2.startAnimation(rotateAnimation2);

                RotateAnimation rotateAnimation3 = new RotateAnimation(0, 360, animateView3.getWidth() / 2, animateView3.getHeight() / 2);
                rotateAnimation3.setDuration(2500);
                rotateAnimation3.setRepeatCount(-1);
                rotateAnimation3.setInterpolator(new LinearInterpolator());
                animateView3.startAnimation(rotateAnimation3);

            }
        });

    }

}
