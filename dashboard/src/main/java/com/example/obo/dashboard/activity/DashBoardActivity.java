package com.example.obo.dashboard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.obo.dashboard.R;
import com.example.obo.dashboard.fragment.DashBoardFragment;

public class DashBoardActivity extends AppCompatActivity {

    DashBoardFragment dashBoardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        dashBoardFragment = (DashBoardFragment) getFragmentManager().findFragmentById(R.id.fragment_dashboard);
        dashBoardFragment.attach(this);
    }

}
