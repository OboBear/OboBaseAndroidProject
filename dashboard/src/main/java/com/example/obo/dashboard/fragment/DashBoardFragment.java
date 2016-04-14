package com.example.obo.dashboard.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.obo.dashboard.R;
import com.example.obo.dashboard.animate.CompassRotateAnimation;
import com.example.obo.dashboard.widget.ColorDragView;

public class DashBoardFragment extends Fragment {

    public static final String TAG = DashBoardFragment.class.getCanonicalName();

    Activity activity;

    View viewDashBackGround;

    TextView textSpeed;

    ColorDragView colorDragView;

    ImageView imgCompass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "TAG:onCreate:attach");
    }

    public void attach(Context context) {
        this.activity = (Activity) context;

        Log.i(TAG,"TAG:attach");

        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textSpeed.setText("" + (int) colorDragView.randANewValue((int) (Math.random() * 150)));
                        }
                    });
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "TAG:onCreateView");
        View contentView = inflater.inflate(R.layout.fragment_dash_board, container, false);
        initViews(contentView);

        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "TAG:onStart");
    }

    private void initViews(View contentView) {
        viewDashBackGround = contentView.findViewById(R.id.lay_dashboard);
        textSpeed = (TextView) contentView.findViewById(R.id.text_speed);
        colorDragView = (ColorDragView) contentView.findViewById(R.id.view_color_drag);
        imgCompass = (ImageView) contentView.findViewById(R.id.img_compass);

        ViewTreeObserver viewTreeObserver = imgCompass.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                CompassRotateAnimation animation = new CompassRotateAnimation(10, 60, imgCompass.getWidth() / 2, imgCompass.getHeight() / 2);

                animation.setDuration(2000);
                animation.setRepeatCount(-1);
                imgCompass.startAnimation(animation);
            }
        });

    }

}
