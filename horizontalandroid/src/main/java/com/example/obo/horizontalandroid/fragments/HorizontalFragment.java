package com.example.obo.horizontalandroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.obo.horizontalandroid.R;

/**
 * Created by obo on 16/4/1.
 * Email:obo1993@gmail.com
 */
public class HorizontalFragment extends Fragment {

    Activity mActivity;

    View mContentView;

    public HorizontalFragment(Activity activity) {
        super();
        this.mActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mContentView = inflater.inflate(R.layout.content_horizontal, null);
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    void initViews() {


        DisplayMetrics displayMetrics = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);      // 获取屏幕的尺寸
        int width = displayMetrics.widthPixels;                         // 屏幕宽
        int height = displayMetrics.heightPixels;                       // 屏幕高

        LinearLayout layout = (LinearLayout) mContentView.findViewById(R.id.layout_horizontal);  // 待旋转布局

        layout.setLayoutParams(new LinearLayout.LayoutParams(height, width));       // 设置布局的宽和高,必须要和屏幕的反过来
        layout.setRotation(90);             // 顺时针旋转90度
        layout.setY((height - width) / 2);
        layout.setX((width - height) / 2);  // 将布局位移到屏幕中心
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();
    }
}
