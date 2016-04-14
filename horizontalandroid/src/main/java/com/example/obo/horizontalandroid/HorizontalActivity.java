package com.example.obo.horizontalandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import com.example.obo.horizontalandroid.fragments.HorizontalFragment;

import java.util.ArrayList;
import java.util.List;

public class HorizontalActivity extends AppCompatActivity {

    HorizontalFragment horizontalFragment;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        List<Fragment>fragments = new ArrayList<>();
        fragments.add(new HorizontalFragment(this));
        fragments.add(new HorizontalFragment(this));

        mViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setCurrentItem(0);

    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {

        List <Fragment> mFragmentList;


        public MyFragmentAdapter(FragmentManager fm,List <Fragment> fragmentList) {
            super(fm);
            this.mFragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}
