package com.obo.reverseview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.obo.reverseview.R;
import com.obo.reverseview.animate.AnimateReverseActivity;
import com.obo.reverseview.animate.Rotate3dAnimation;
import com.obo.reverseview.layout.LayoutReverseActivity;
import com.obo.reverseview.surfaceView.SurfaceReverseActivity;

public class ReverseActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String ACTION = "com.obo.reverseview.action.ReverseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button) {
            Intent intent = new Intent(this, AnimateReverseActivity.class);
            startActivity(intent);

        } else if (i == R.id.button2) {
            Intent intent = new Intent(this, LayoutReverseActivity.class);
            startActivity(intent);

        } else if (i == R.id.button3) {
            Intent intent = new Intent(this, SurfaceReverseActivity.class);
            startActivity(intent);
        }
    }
}
