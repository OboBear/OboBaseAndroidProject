package com.me.obo.calldownloader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

/**
 * Created by obo on 16/9/4.
 * Email:obo.lin@dingtone.me
 */
public class DownloadAdapter extends BaseAdapter {

    private static final String TAG = "DownloadAdapter";

    private List<Download> mDownloadList;

    private Activity mActivity;

    private LayoutInflater mLayoutInflater;

    public DownloadAdapter(Activity context, List<Download>downloadList) {
        this.mActivity = context;
        this.mDownloadList = downloadList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDownloadList == null ? 0 :mDownloadList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDownloadList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder ;

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.download_item, null);

            viewHolder = new ViewHolder();
            viewHolder.tvDownloadUrl = (TextView) view.findViewById(R.id.tv_download_url);
            viewHolder.tvLocalPath = (TextView) view.findViewById(R.id.tv_local_path);
            viewHolder.btnDownloadUrl = (Button) view.findViewById(R.id.btn_download);
            viewHolder.btnLocalPath = (Button) view.findViewById(R.id.btn_dir);
            viewHolder.btnLocalPath.setOnClickListener(openListener);
            viewHolder.pbDownloadRate = (ProgressBar) view.findViewById(R.id.pb_download_rate);
            viewHolder.btnDownloadUrl.setOnClickListener(onClickListener);


            viewHolder.pbDownloadRate.setProgress(50);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Download download = mDownloadList.get(i);
        viewHolder.download = download;
        viewHolder.tvDownloadUrl.setText(download.downloadPath);
        viewHolder.tvLocalPath.setText(download.localPath);
        viewHolder.btnDownloadUrl.setTag(viewHolder);
        viewHolder.btnLocalPath.setTag(viewHolder);
        view.setTag(viewHolder);
        return view;
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final ViewHolder viewHolder = (ViewHolder) view.getTag();
            Download download = viewHolder.download;
            File file = new File(download.localPath);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileDownloader fileDownloader = new FileDownloader(new FileDownloaderListener() {
                @Override
                public void onDownloadComplete(long totalSize) {
                    Log.i(TAG, "onDownloadComplete totalSize = " + totalSize );
                }

                @Override
                public void onDonwloading(final long totalSize, final long downloaded) {
                    Log.i(TAG, "onDonwloading totalSize = " + totalSize + " downloaded = " + downloaded);
                    mActivity.runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    viewHolder.pbDownloadRate.setProgress((int)(downloaded * 100 / totalSize));
                                                }
                                            });

                }

                @Override
                public void onDownloadStart() {
                    Log.i(TAG, "onDownloadStart");

                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewHolder.pbDownloadRate.setProgress(0);
                        }
                    });

                }

                @Override
                public void onDonwloadFailed(String errorMsg) {
                    Log.i(TAG, "onDonwloadFailed errorMsg = " + errorMsg);
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mActivity, "error" , Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
            fileDownloader.downLoadFile(download.downloadPath,download.localPath);
            Log.i("","");
        }
    };

    private View.OnClickListener openListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            Download download = viewHolder.download;
            OpenSystemFile(MainActivity.DOWNLOAD_FILE_PATH);
        }
    };

    private static final int FILE_SELECT_CODE = 0X111;

    private void OpenSystemFile(String path) {
        //getUrl()获取文件目录，例如返回值为/storage/sdcard1/MIUI/music/mp3_hd/单色冰淇凌_单色凌.mp3
        File file = new File(path);
//获取父目录
        File parentFlie = new File(file.getParent());
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setDataAndType(Uri.fromFile(parentFlie), "*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        mActivity.startActivity(intent);
    }

    class ViewHolder {

        TextView tvDownloadUrl;
        TextView tvLocalPath;
        Button btnDownloadUrl;
        Button btnLocalPath;
        ProgressBar pbDownloadRate;
        Download download;
    }
}
