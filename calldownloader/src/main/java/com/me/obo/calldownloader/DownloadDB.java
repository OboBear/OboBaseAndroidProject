package com.me.obo.calldownloader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by obo on 16/9/4.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class DownloadDB extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    private static final String DOWNLOAD = "download";


    public DownloadDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DownloadDB(Context context) {
        super(context, "download_db", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table download(downloadId INTEGER PRIMARY KEY AUTOINCREMENT,downloadPath varchar(255),localPath varchar(255))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public List<Download> getDownloadList() {
        List<Download>downloadList = new ArrayList<>();
        SQLiteDatabase sqLiteOpenHelper = getReadableDatabase();
        Cursor cursor = sqLiteOpenHelper.query(DOWNLOAD, new String[] {}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Download download = new Download();

            download.downloadId = cursor.getInt(cursor.getColumnIndex("downloadId"));
            download.downloadPath = cursor.getString(cursor.getColumnIndex("downloadPath"));
            download.localPath = cursor.getString(cursor.getColumnIndex("localPath"));

            downloadList.add(download);
        }

        return downloadList;

    }

    public void setDownload(Download download) {
        SQLiteDatabase sqLiteOpenHelper = getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put("downloadId",download.downloadId);
        values.put("downloadPath",download.downloadPath);
        values.put("localPath",download.localPath);
        sqLiteOpenHelper.insert(DOWNLOAD, null, values);
    }
}
