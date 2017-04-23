package com.me.obo.wirelessinstallapk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class FileListAdapter extends BaseAdapter {

    private List<FileTransmissionModel> fileTransmissionModelList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public FileListAdapter(Context context, List<FileTransmissionModel> fileTransmissionModelList) {
        this.fileTransmissionModelList = fileTransmissionModelList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return fileTransmissionModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FileListItemHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.file_item, null);
            holder = new FileListItemHolder();
            holder.tvFileName = (TextView) convertView.findViewById(R.id.tv_file_name);
            holder.pbDownloadRate = (ProgressBar) convertView.findViewById(R.id.pb_download_rate);
            holder.pbDownloadRate.setMax(100);
            convertView.setTag(holder);
        } else {
            holder = (FileListItemHolder) convertView.getTag();
        }
        FileTransmissionModel fileTransmissionModel = fileTransmissionModelList.get(position);
        holder.tvFileName.setText(fileTransmissionModel.getFileName());
        holder.pbDownloadRate.setProgress((int) (fileTransmissionModel.getCurrentSize() * 100 / fileTransmissionModel.getFileSize()));
        return convertView;
    }

    private static class FileListItemHolder {
        TextView tvFileName;
        ProgressBar pbDownloadRate;
    }
}
