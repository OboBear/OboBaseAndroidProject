package com.obo.mydemos.fresco;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obo.activity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FrescoActivity extends AppCompatActivity {
    public static String ACTION = "com.obo.activity.intent.action.FrescoActivity";
    @Bind(R.id.my_image_view)
    protected SimpleDraweeView my_image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initContentView();
    }

    private void initContentView()
    {
//        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/fresco-logo.png");
        Uri uri = Uri.parse("http://img3.imgtn.bdimg.com/it/u=2289772245,257967834&fm=21&gp=0.jpg");
        my_image_view.setImageURI(uri);

        RoundingParams roundingParams = RoundingParams.fromCornersRadius(7f);
        roundingParams.setOverlayColor(Color.RED);
//        RoundingParams roundingParams = my_image_view.getHierarchy().getRoundingParams();
        roundingParams.setRoundAsCircle(true);
        my_image_view.getHierarchy().setRoundingParams(roundingParams);
    }

}
