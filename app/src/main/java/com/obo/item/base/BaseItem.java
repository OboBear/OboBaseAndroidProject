package com.obo.item.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by obo on 15/8/22.
 */
public abstract class BaseItem {
    protected Context context;

    public abstract View getView(int position, View convertView, ViewGroup parent,LayoutInflater layoutInflater);
}
