package com.obo.reverseview.myblur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.obo.reverseview.R;

public class BlurActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
//        imageView = (ImageView) findViewById(R.id.img);
//        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.dog);

//        imageView.setImageBitmap(bitmap);

    }
}
