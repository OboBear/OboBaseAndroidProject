package com.obo.mydemos.porterduff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.obo.activity.R;

public class PorterDuffActivity extends AppCompatActivity {
    public final static String ACTION = "com.obo.activity.intent.action.PorterDuffActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porter_duff);
        initContentView();

    }

    private void initContentView()
    {
        Bitmap left_back = BitmapFactory.decodeResource(getResources(),R.drawable.left_back);

        Bitmap left_back_2 = BitmapFactory.decodeResource(getResources(), R.drawable.left_back_2);


        Bitmap left_back_copy = left_back.copy(Bitmap.Config.ARGB_8888,true);
        Canvas canvas1 = new Canvas(left_back_copy);
        Paint porterDuffPaint = new Paint();
        porterDuffPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas1.drawBitmap(left_back_2, 5, 5, porterDuffPaint);
        canvas1.drawRect(0,0,4,4,new Paint());
    }

}
