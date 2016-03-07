package com.obo.mydemos.ndk;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class NdkActivity extends BaseActivity {
    public final static String ACTION = "com.obo.activity.intent.action.NdkActivity";

    static
    {
        System.loadLibrary("ndkActivity");
    }

    public native int getNDKInt();

    public native String getNDKString();

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);
        initContentView();
    }

    @Override
    public void onClick(View sender) {

    }

    private void initContentView()
    {
        textView = $(R.id.textView);
        textView.setText(""+getNDKInt()+"  "+getNDKString());
    }

}
