package com.me.obo.getapppackages;

import android.content.pm.PackageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<PackageInfo> packageInfos = getPackageManager().getInstalledPackages(0);

        for (PackageInfo packageInfo : packageInfos) {
            Log.i("MainActivity",""+ packageInfo.packageName);
        }



    }
}
