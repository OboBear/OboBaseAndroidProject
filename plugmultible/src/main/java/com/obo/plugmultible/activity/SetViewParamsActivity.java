package com.obo.plugmultible.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.obo.plugmultible.R;
import com.obo.plugmultible.model.ViewModel;

public class SetViewParamsActivity extends AppCompatActivity {

    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_set_view_params);

        initDatas();
    }


    private void initDatas() {

        Intent integer = getIntent();
        viewModel = (ViewModel) integer.getSerializableExtra("data");
    }
}
