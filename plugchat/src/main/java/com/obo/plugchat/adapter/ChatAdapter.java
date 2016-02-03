package com.obo.plugchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.obo.plugchat.R;
import com.obo.plugchat.model.ChatModel;
import com.obo.plugchat.widget.CircleImageView;

import java.util.ArrayList;

/**
 * Created by obo on 16/1/29.
 */
public class ChatAdapter extends BaseAdapter {

    ArrayList<ChatModel> chatModels;
    LayoutInflater layoutInflater;

    public ChatAdapter(Context context, ArrayList<ChatModel> chatModels) {
        layoutInflater = LayoutInflater.from(context);
        this.chatModels = chatModels;
    }

    @Override
    public int getCount() {
        return chatModels.size();
    }

    @Override
    public Object getItem(int position) {
        return chatModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return chatModels.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatModel chatModel = chatModels.get(position);
        SurfaceHolder surfaceHolder;
        if (convertView == null) {
            surfaceHolder = new SurfaceHolder();
            if (chatModel.getType() == 0) {
                convertView = layoutInflater.inflate(R.layout.item_me, null);
            } else {
                convertView = layoutInflater.inflate(R.layout.item_other, null);
            }

            surfaceHolder.textContent = (TextView) convertView.findViewById(R.id.text_content);
            surfaceHolder.imgHead = (CircleImageView) convertView.findViewById(R.id.img_head);
            convertView.setTag(surfaceHolder);
        } else {
            surfaceHolder = (SurfaceHolder) convertView.getTag();
        }

        surfaceHolder.textContent.setText(chatModel.getContent());

        return convertView;
    }

    class SurfaceHolder {
        TextView textContent;
        CircleImageView imgHead;
    }
}
