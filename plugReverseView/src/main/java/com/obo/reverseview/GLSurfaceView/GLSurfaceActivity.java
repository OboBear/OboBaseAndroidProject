package com.obo.reverseview.GLSurfaceView;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.obo.reverseview.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GLSurfaceActivity extends AppCompatActivity {

    CustomGLSurfaceView customGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        customGLSurfaceView = (CustomGLSurfaceView) findViewById(R.id.glsurface);
//        customGLSurfaceView.setRenderer(new BitmapGLRender(this));
        customGLSurfaceView.setRenderer(new MyGLRender(this));
    }

}
