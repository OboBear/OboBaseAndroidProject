package com.me.obo.wirelessinstallapk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;
import com.me.obo.wirelessinstalllog.WILog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WIProtocol.WIView {

    private static final String TAG = "MainActivity";

    private Button btnConnect;
    private TextView tvHostIp;
    private TextView tvHasDownloaded;
    private ListView lvDownloadedFile;
    private View vConnectStatus;

    private MainActivityPrecenter mainActivityPrecenter;

    private List<FileTransmissionModel> fileTransmissionModelList = new ArrayList<>();

    private FileListAdapter fileListAdapter;

    private WeakReference<Activity> weakReferenceActivity = new WeakReference<Activity>(this);

    private boolean isConnected = false;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WILog.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        findViews();
        mainActivityPrecenter = new MainActivityPrecenter();
        mainActivityPrecenter.start(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void findViews() {
        btnConnect = (Button) findViewById(R.id.btn_connect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivityPrecenter != null) {
                    mainActivityPrecenter.startConnect();
                }
            }
        });
        tvHostIp = (TextView) findViewById(R.id.tv_host_ip);
        tvHasDownloaded = (TextView) findViewById(R.id.tv_has_downloaded);
        lvDownloadedFile = (ListView) findViewById(R.id.lv_downloaded_file);

        fileListAdapter = new FileListAdapter(this, fileTransmissionModelList);
        lvDownloadedFile.setAdapter(fileListAdapter);
        vConnectStatus = findViewById(R.id.v_connect_status);
        setConnectStatus(false);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showHostIp(final String hostIp) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            tvHostIp.setText(hostIp);
        } else {
            tvHostIp.post(new Runnable() {
                @Override
                public void run() {
                    tvHostIp.setText(hostIp);
                }
            });
        }
    }

    @Override
    public void updateFileTransmission(FileTransmissionModel fileTransmissionModel) {
        WILog.i(TAG, "uodateFileTransmission fileName = " + fileTransmissionModel.getFileName());
        if (!fileTransmissionModelList.contains(fileTransmissionModel)) {
            fileTransmissionModelList.add(fileTransmissionModel);
        }
        lvDownloadedFile.post(new Runnable() {
            @Override
            public void run() {
                fileListAdapter.notifyDataSetChanged();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setConnectStatus(final boolean isConnected) {
        this.isConnected = isConnected;
        vConnectStatus.post(new Runnable() {
            @Override
            public void run() {
                Activity activity = weakReferenceActivity.get();
                if (isConnected && activity != null) {
                    AnimationSet animation = (AnimationSet) AnimationUtils.loadAnimation(activity, R.anim.bling);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            WILog.i(TAG, "onAnimationStart");
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            WILog.i(TAG, "onAnimationEnd");
                            vConnectStatus.clearAnimation();
                            if (MainActivity.this.isConnected) {
                                vConnectStatus.startAnimation(animation);
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    vConnectStatus.startAnimation(animation);
                    vConnectStatus.setBackground(getResources().getDrawable(R.drawable.connect_status_green));
                    btnConnect.setVisibility(View.GONE);
                } else {
                    vConnectStatus.setBackground(getResources().getDrawable(R.drawable.connect_status_red));
                    vConnectStatus.clearAnimation();
                    btnConnect.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
