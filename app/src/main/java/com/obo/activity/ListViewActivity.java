package com.obo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.obo.activity.base.BaseActivity;
import com.obo.adapter.base.OBBaseAdapter;
import com.obo.item.MainListItem;
import com.obo.item.base.BaseItem;
import com.obo.model.MainListModel;
import com.obo.mydemos.view.matrix.MatrixActivity;
import com.obo.mydemos.view.moutitouch.MoutiTouchActivity;
import com.obo.mydemos.view.singletouch.SingleTouchActivity;
import com.obo.mydemos.view.singletouch.SingleTouchView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    public static String TAG = ListViewActivity.class.getCanonicalName();

    String[]activityStringName = {
            "ViewSingleTouch",
            "ViewMoutiTouch",
            "ViewMatrix",
            "Service",
            "SurfaceView",
            "NDK"
    };

    String []IntentActions = {
            SingleTouchActivity.ACTION,
            MoutiTouchActivity.ACTION,
            MatrixActivity.ACTION
    };




    public static void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,ListViewActivity.class);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity,Serializable extraData)
    {
        Intent intent = new Intent(activity,ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extraData",extraData);
        intent.putExtra("bundle", bundle);
        activity.startActivity(intent);
    }


    List<BaseItem> dataSource = new ArrayList<BaseItem>();

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initDatas();
        initContentView();

        showMemInfo();
    }

    @Override
    protected void onClick(View sender) {

    }


    private void initDatas()
    {

        for (int i=0;i<activityStringName.length;i++)
        {
            MainListModel model = new MainListModel();

            model.text = activityStringName[i];
            dataSource.add(new MainListItem(model));
        }
    }

    protected void initContentView() {
        listView = $(R.id.listView);

        BaseAdapter baseAdapter = new OBBaseAdapter(activity,dataSource);
        listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (IntentActions.length > position) {
            Intent intent = new Intent(IntentActions[position]);
            startActivity(intent);
        }
    }
}
