package com.me.obo.greendaooldversion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by obo on 2017/3/8.
 * Email:obo.lin@dingtone.me
 */

public class DaoManager {
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;

    private static class DaoManagerHolder {
        private static DaoManager instance = new DaoManager();
    }

    public static DaoManager getInstance() {
        return DaoManagerHolder.instance;
    }

    public DaoManager init(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "note", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        return this;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public Cursor getCursor() {
        String textColumn = NoteDao.Properties.Text.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        Cursor cursor = getDb().query(getDaoSession().getNoteDao().getTablename(), getDaoSession().getNoteDao().getAllColumns(), null, null, null, null, orderBy);
        return cursor;
    }
}
