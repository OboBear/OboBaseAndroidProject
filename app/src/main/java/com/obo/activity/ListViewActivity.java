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
import com.obo.mydemos.animate.AnimateActivity;
import com.obo.mydemos.bitmap.BitmapActivity;
import com.obo.mydemos.broadcast.BroadCastActivity;
import com.obo.mydemos.fresco.FrescoActivity;
import com.obo.mydemos.navigation.NavigationActivity;
import com.obo.mydemos.ndk.NdkActivity;
import com.obo.mydemos.okhttp.OkHttpActivity;
import com.obo.mydemos.porterduff.PorterDuffActivity;
import com.obo.mydemos.service.ServiceActivity;
import com.obo.mydemos.singleTop.SingleTopActivity1;
import com.obo.mydemos.socket.SocketActivity;
import com.obo.mydemos.sql.SQLActivity;
import com.obo.mydemos.view.matrix.MatrixActivity;
import com.obo.mydemos.view.moutitouch.MoutiTouchActivity;
import com.obo.mydemos.view.singletouch.SingleTouchActivity;
import com.obo.mydemos.viewpager.ViewPagerActivity;
import com.obo.mydemos.webview.WebViewActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    public static String TAG = ListViewActivity.class.getCanonicalName();

    String[] activityStringName = {
            "ViewSingleTouch",
            "ViewMoutiTouch",
            "ViewMatrix",
            "Service",
            "Animation",
            "Socket",
            "NDK",
            "WebViewActivity",
            "导航",
            "PorterDuff",
            "BitmapActivity",
            "OkHttpActivity",
            "SingleTopActivity",
            "BroadCastActivity",
            "ViewPagerActivity",
            "FrescoActivity",
            "SQLActivity",
//            "SurfaceView",
    };

    String[] IntentActions = {
            SingleTouchActivity.ACTION,
            MoutiTouchActivity.ACTION,
            MatrixActivity.ACTION,
            ServiceActivity.ACTION,
            AnimateActivity.ACTION,
            SocketActivity.ACTION,
            NdkActivity.ACTION,
            WebViewActivity.ACTION,
            NavigationActivity.ACTION,
            PorterDuffActivity.ACTION,
            BitmapActivity.ACTION,
            OkHttpActivity.ACTION,
            SingleTopActivity1.ACTION,
            BroadCastActivity.ACTION,
            ViewPagerActivity.ACTION,
            FrescoActivity.ACTION,
            SQLActivity.ACTION,

    };

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, ListViewActivity.class);
        activity.startActivity(intent);
    }

    public static void startActivity(Activity activity, Serializable extraData) {
        Intent intent = new Intent(activity, ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extraData", extraData);
        intent.putExtra("bundle", bundle);
        activity.startActivity(intent);
    }


    List<BaseItem> dataSource = new ArrayList<BaseItem>();

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initDatas();
        initContentView();

        showMemInfo();
    }

    @Override
    public void onClick(View sender) {

    }


    private void initDatas() {

        for (int i = 0; i < activityStringName.length; i++) {
            MainListModel model = new MainListModel();

            model.text = activityStringName[i];
            dataSource.add(new MainListItem(model));
        }
    }

    protected void initContentView() {

        try {
            String sourceString = "com.obo.activity.R.id.listView";
            StringBuffer stringBuffer = new StringBuffer();
            String[] splits = sourceString.split("[.]");

            for (int i = 0; i < splits.length - 2; i++) {
                if (i != 0)
                    stringBuffer.append(".");
                stringBuffer.append(splits[i]);
            }
            stringBuffer.append("$");
            stringBuffer.append(splits[splits.length - 2]);

            Class<?> cls = Class.forName(stringBuffer.toString());

            int idValue = cls.getField(splits[splits.length - 1]).getInt(splits[splits.length - 1]);

            System.out.println("" + idValue);
            listView = $(idValue);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        BaseAdapter baseAdapter = new OBBaseAdapter(activity, dataSource);
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
