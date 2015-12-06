package com.obo.reverseview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;

import com.obo.reverseview.animate.Rotate3dAnimation;

public class AnimateReverseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final View layoutView = findViewById(R.id.reverse_layout);
//
//        ViewTreeObserver vto = layoutView.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//
//                Animation animation = new Rotate3dAnimation(0, 180, layoutView.getMeasuredWidth() / 2, layoutView.getMeasuredHeight() / 2);
//                animation.setFillAfter(true);
//                layoutView.startAnimation(animation);
//            }
//        });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.reverse_button:
                View layout = findViewById(R.id.reverse_layout);
                Animation animation = new Rotate3dAnimation(0, 180, layout.getWidth() / 2, layout.getHeight() / 2);
                animation.setFillAfter(true);
                layout.startAnimation(animation);
                break;
        }
    }
}
