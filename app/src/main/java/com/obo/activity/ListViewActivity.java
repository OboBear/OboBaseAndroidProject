package com.obo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.obo.activity.base.BaseActivity;
import com.obo.adapter.base.OBBaseAdapter;
import com.obo.item.MainListItem;
import com.obo.item.base.BaseItem;
import com.obo.model.MainListModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends BaseActivity {

    public static String TAG = ListViewActivity.class.getCanonicalName();

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
    }


    private void initDatas()
    {
        String[]activityStringName = {
                "ViewSingleTouch",
                "ViewMoutiTouch",
                "ViewMatrix",
                "SurfaceView",
                "NDK"
        };

        for (int i=0;i<activityStringName.length;i++)
        {
            MainListModel model = new MainListModel();

            model.text = activityStringName[i];
            dataSource.add(new MainListItem(model));
        }

    }


    @Override
    protected void initContentView() {
        listView = $(R.id.listView);

        BaseAdapter baseAdapter = new OBBaseAdapter(activity,dataSource);
        listView.setAdapter(baseAdapter);
    }


}
