package com.obo.mydemos.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class BitmapActivity extends BaseActivity {
    public final static String ACTION = "com.obo.activity.intent.action.BitmapActivity";
    public final static String TAG = BitmapActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.left_back);

//        160X160
//        921600
        Log.i(TAG, "bitmap.getByteCount():" + bitmap.getByteCount());
//        bitmap.getByteCount();

    }

    @Override
    public void onClick(View sender) {

    }

}
