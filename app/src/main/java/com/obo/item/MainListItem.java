package com.obo.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obo.activity.R;
import com.obo.item.base.BaseItem;
import com.obo.model.MainListModel;

import org.w3c.dom.Text;

/**
 * Created by obo on 15/8/22.
 */
public class MainListItem extends BaseItem {
    public static String TAG = MainListItem.class.getCanonicalName();


    MainListModel model;

    public MainListItem(MainListModel model)
    {
        this.model = model;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent,LayoutInflater layoutInflater) {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.item_main_list,null);

            viewHolder = new ViewHolder();

            viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(model.text);

        return convertView;
    }

    class ViewHolder{

        TextView textView;
    }

}
