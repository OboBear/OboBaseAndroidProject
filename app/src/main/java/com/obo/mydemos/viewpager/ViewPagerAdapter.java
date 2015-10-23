package com.obo.mydemos.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by obo on 15/10/22.
 */
public class ViewPagerAdapter extends PagerAdapter {

    List<View>viewList;
    List<String>titleName;
    Context context;

    public ViewPagerAdapter(Context context,List<View>viewList,List<String>titleName)
    {
        this.context = context;
        this.viewList = viewList;
        this.titleName = titleName;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position)
    {
        container.addView(viewList.get(position),0);

        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)   {
        container.removeView(viewList.get(position));//删除页卡
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleName.get(position);
    }


    @Override
    public float getPageWidth(int position)
    {
        if (position==1)
        return 0.2f;
        else return super.getPageWidth(position);
    }


}
