package com.me.obo.greendaooldversion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.greenrobot.dao.query.Query;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    MyAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_test_show).setOnClickListener(this);
        findViewById(R.id.btn_test_add).setOnClickListener(this);
        findViewById(R.id.btn_test_clean).setOnClickListener(this);
        listView = (ListView) findViewById(R.id.lv_data);
        DaoManager.getInstance().init(this);

    }


    private void show() {
        Query query = DaoManager.getInstance().getDaoSession().getNoteDao().queryBuilder()
                .where(NoteDao.Properties.Text.eq("2333"))
                .orderAsc(NoteDao.Properties.Date)
                .build();
        List notes = query.list();
        Log.i("", "");

        if (myAdapter == null) {
            myAdapter = new MyAdapter(this, notes);
            listView.setAdapter(myAdapter);
        } else {
            myAdapter.setNoteList(notes);
            myAdapter.notifyDataSetChanged();
        }
    }


    private void clean() {
        DaoManager.getInstance().getDaoSession().getNoteDao().deleteAll();
        Cursor cursor = DaoManager.getInstance().getCursor();
        cursor.requery();
        cursor.close();
    }

    private void add() {
        Note note = new Note();
        note.setComment("123");
        note.setText("2333");
        note.setDate(new Date(System.currentTimeMillis()));
        DaoManager.getInstance().init(this).getDaoSession().getNoteDao().insert(note);
        Cursor cursor = DaoManager.getInstance().getCursor();
        cursor.requery();
        cursor.close();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_show:
                show();
                break;
            case R.id.btn_test_add:
                add();
                break;
            case R.id.btn_test_clean:
                clean();
                break;
        }
    }
}
