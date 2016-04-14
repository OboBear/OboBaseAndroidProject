package com.obo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.obo.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runtime.getRuntime().maxMemory();
        Runtime.getRuntime().totalMemory();
        Runtime.getRuntime().freeMemory();
    }

    protected void initContentView() {
        TextView text_view = $(R.id.text_view);
        text_view.setText("测试");
    }

    public void onClick(View sender)
    {
        switch (sender.getId())
        {
            case R.id.button:

                ListViewActivity.startActivity(this);

                break;
        }
    }
}
