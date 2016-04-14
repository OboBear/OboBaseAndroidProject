package com.example.obo.gapdemaptest;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.amap.api.maps.MapsInitializer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            MapsInitializer.initialize(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);
    }
}
