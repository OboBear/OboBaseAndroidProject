package com.obo.mydemos.okhttp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;
import com.obo.utils.network.socket.flowget.OBSocketFlowGet;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttpActivity extends BaseActivity {
    public static String ACTION = "com.obo.activity.intent.action.OkHttpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
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
        
    }

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();

        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    @Override
    public void onClick(View sender) {

    }

}
