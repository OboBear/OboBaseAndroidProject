package com.obo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.obo.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
