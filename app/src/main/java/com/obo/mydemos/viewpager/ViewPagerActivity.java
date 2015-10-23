package com.obo.mydemos.viewpager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;

import com.obo.activity.R;
import com.obo.utils.network.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {

    public static String ACTION = "com.obo.activity.intent.action.ViewPagerActivity";

    @Bind(R.id.viewPager)
    ViewPager viewPager;


    @Bind(R.id.tabStrip)
    PagerTabStrip tabStrip;

    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ButterKnife.bind(this);

        List<View>viewList = new ArrayList<View>();

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        viewList.add( layoutInflater.inflate(R.layout.activity_bitmap,null));
        viewList.add( layoutInflater.inflate(R.layout.leftbar_list,null));

        List<String>titleName = new ArrayList<String>();
        titleName.add("he");
        titleName.add("niha");
        pagerAdapter = new ViewPagerAdapter(this,viewList,titleName);


        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtil.i(this,"position:"+position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        pagerAdapter.notifyDataSetChanged();

//        tabStrip.setDrawFullUnderline(false);

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
    }

}
