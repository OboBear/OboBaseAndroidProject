package com.me.obo.greendaooldversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by obo on 2017/3/8.
 * Email:obo.lin@dingtone.me
 */

public class MyAdapter extends BaseAdapter {
    private static final String TAG = "MyAdapter";

    private List<Note> noteList = new ArrayList<>();
    private LayoutInflater layoutInflater = null;
    public MyAdapter(Context context, List<Note> noteList) {
        this.noteList = noteList;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }


    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyAdapterHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item, null);
            holder = new MyAdapterHolder();
            holder.tvComment = (TextView) view.findViewById(R.id.tv_comment);
            holder.tvText = (TextView) view.findViewById(R.id.tv_text);
            holder.tvId = (TextView) view.findViewById(R.id.tv_id);
            view.setTag(holder);
        } else {
            holder = (MyAdapterHolder) view.getTag();
        }

        holder.tvComment.setText(noteList.get(i).getComment());
        holder.tvText.setText(noteList.get(i).getText());
        holder.tvId.setText(noteList.get(i).getId() + "");

        return view;
    }

    class MyAdapterHolder {

        TextView tvId;
        TextView tvComment;
        TextView tvText;

    }
}
