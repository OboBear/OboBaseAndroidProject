package com.obo.pluganimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        textView = (TextView) findViewById(R.id.textView);

        AnimationSet animation = (AnimationSet) AnimationUtils.loadAnimation(this,R.anim.animate);
        animation.setRepeatCount(Animation.INFINITE);

        textView.startAnimation(animation);
    }
}
