package com.obo.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obo.item.base.BaseItem;

import java.util.List;

/**
 * Created by obo on 15/8/22.
 */
public class OBBaseAdapter extends android.widget.BaseAdapter {

    public static String TAG = OBBaseAdapter.class.getCanonicalName();

    List<BaseItem>      dataResource;
    Context             context;
    LayoutInflater      layoutInflater;

    public OBBaseAdapter(Context context,List<BaseItem>dataResource)
    {
        this.dataResource   = dataResource;
        this.context        = context;
        this.layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return dataResource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataResource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseItem baseItem = dataResource.get(position);
        return baseItem.getView(position, convertView, parent,layoutInflater);
    }
}
