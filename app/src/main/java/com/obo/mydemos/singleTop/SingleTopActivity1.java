package com.obo.mydemos.singleTop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

import java.util.ArrayList;

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

                ArrayList<ArrayList<CustomClass>>data = new ArrayList<ArrayList<CustomClass>>();
                ArrayList<CustomClass>d1 = new ArrayList<CustomClass>();
                CustomClass temp = new CustomClass("this is my object");
                d1.add(temp);
                data.add(d1);
                Intent intent = new Intent(JumpToMainActivity.ACTION);
                intent.putExtra("data",data);
                startActivity(intent);
                break;
        }
    }
}
