package com.obo.mydemos.touch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.obo.activity.R;

public class TouchActivity extends AppCompatActivity {

    public static String ACTION = "com.obo.activity.intent.action.TouchActivity";

    ImageView bodyImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
    }

    public void onClick(View view)
    {
        String whereToClick = "你点击了";
        switch (view.getId())
        {
            case R.id.head_botton:
                whereToClick+="头";

                break;
            case R.id.hand_botton_1:
                whereToClick+="右手";
                break;
            case R.id.hand_botton_2:
                whereToClick+="左手";
                break;
            case R.id.belly_botton:
                whereToClick+="腹部";
                break;
            case R.id.feet_botton_1:
                whereToClick+="右脚";
                break;
            case R.id.feet_botton_2:
                whereToClick+="左脚";
                break;


        }

        Toast.makeText(TouchActivity.this, whereToClick, Toast.LENGTH_SHORT).show();
    }


}
