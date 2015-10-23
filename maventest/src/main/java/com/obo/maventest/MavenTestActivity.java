package com.obo.maventest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class MavenTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void onMaven();

}
