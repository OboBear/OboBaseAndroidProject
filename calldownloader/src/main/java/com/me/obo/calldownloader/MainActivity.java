package com.me.obo.calldownloader;

import android.app.DownloadManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    https://vt.tumblr.com/tumblr_ocalmoDu8Z1v7ki3o_480.mp4

    private static final String TAG = "MainActivity";

    public static final String DOWNLOAD_FILE_PATH
            = Environment.getExternalStorageDirectory().toString()
            + "/" + "OboDownLoad";

    private List<Download> mDownloadList;

    private DownloadDB mDownloadDB;

    private ListView lvDownload;
    private DownloadAdapter mDownloadAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initContentViews();
    }

    private void initDatas() {
        getDataFromDB();

        String downloadPath = getDownloadString();
        if (downloadPath != null) {
            Download download = makeDownload(downloadPath);
            mDownloadList.add(download);
            mDownloadDB.setDownload(download);
        }
    }

    private void getDataFromDB() {
        mDownloadDB = new DownloadDB(this);
        mDownloadList = mDownloadDB.getDownloadList();
        Log.i(TAG,"getDataFromDB");
    }

    private String getDownloadString() {
        String downloadPath = null;
        Intent intent = getIntent();
        Uri downloadUri = intent.getData();
        if (downloadUri != null) {
            downloadPath = downloadUri.toString();
        }
        return downloadPath;
    }

    private Download makeDownload(String downloadPath) {
        String fileName = getFileName(downloadPath);
        Download download = new Download();
        download.downloadPath =  downloadPath;
        download.localPath = DOWNLOAD_FILE_PATH + "/" + fileName;

        return download;
    }

    private void initContentViews() {
        lvDownload = (ListView) findViewById(R.id.lv_download);
        mDownloadAdapter = new DownloadAdapter(this,mDownloadList);
        lvDownload.setAdapter(mDownloadAdapter);
    }

    private String getFileName(String fileUrl) {
        String fileName = null;
        if (fileUrl != null) {
            String [] splits = fileUrl.split("/");
            fileName = splits[splits.length - 1];
        }

        return fileName;
    }

}
