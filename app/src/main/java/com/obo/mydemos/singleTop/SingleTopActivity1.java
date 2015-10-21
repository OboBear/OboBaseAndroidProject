package com.obo.mydemos.singleTop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class SingleTopActivity1 extends BaseActivity {
    public static String ACTION = "com.obo.activity.intent.action.SingleTopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top1);
    }

    @Override
    public void onClick(View sender) {
        switch (sender.getId())
        {
            case R.id.textView:
                startActivity(new Intent(JumpToMainActivity.ACTION));
                break;
        }
    }
}
