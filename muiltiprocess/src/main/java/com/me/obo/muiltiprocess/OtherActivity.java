package com.me.obo.muiltiprocess;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by obo on 16/8/9.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class OtherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        setContentView(layoutInflater.inflate(R.layout.other_activity,null));



    }
}
