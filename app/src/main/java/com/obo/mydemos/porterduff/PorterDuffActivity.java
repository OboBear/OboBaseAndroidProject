package com.obo.mydemos.porterduff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;
import com.obo.utils.image.ImageUtil;

public class PorterDuffActivity extends BaseActivity {
    public final static String ACTION = "com.obo.activity.intent.action.PorterDuffActivity";

    ImageView image_duff ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porter_duff);
        initContentView();

    }

    @Override
    public void onClick(View sender) {

    }

    private void initContentView()
    {
        image_duff = $(R.id.image_duff);

        Bitmap bitmap = Bitmap.createBitmap(200,200, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(150,150,50,paint);

        image_duff.setImageBitmap(ImageUtil.makeCirclePorterDuffBitmap(bitmap,10,60));

    }

}
