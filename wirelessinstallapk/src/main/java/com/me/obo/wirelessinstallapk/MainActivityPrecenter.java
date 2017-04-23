package com.me.obo.wirelessinstallapk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.me.obo.wirelessinstalllib.WirelessInstallManager;
import com.me.obo.wirelessinstalllib.WirelessInstallManagerListener;
import com.me.obo.wirelessinstalllib.broadcast.BroadcastReceiveManager;
import com.me.obo.wirelessinstalllib.broadcast.BroadcastReceiveManagerListener;
import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;
import com.me.obo.wirelessinstalllog.WILog;

import java.io.File;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class MainActivityPrecenter implements WIProtocol.ConnectPresenter {

    private static final String TAG = "MainActivityPrecenter";

    WIProtocol.WIView view;

    @Override
    public void start(WIProtocol.WIView view) {
        this.view = view;
        startConnect();
    }

    @Override
    public void startConnect() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                BroadcastReceiveManager.getInstance().startReceive(new BroadcastReceiveManagerListener() {
                    @Override
                    public void onFailed(String errorMsg) {
                        WILog.i(TAG, "onStartFailed errorMsg = " + errorMsg);
                    }
                    @Override
                    public void onReceiveMSG(String ip, int port) {
                        WILog.i(TAG, "onReceiveMSG " + ip + " ; port = " + port);
                        if (view != null) {
                            view.showHostIp(ip);
                        }
                        connectToIp(ip, port);
                    }
                });
            }
        }.start();
    }

    private void connectToIp(String ipString, int port) {

        WirelessInstallManager.getInstance().setWirelessInstallManagerListener(new WirelessInstallManagerListener() {

            @Override
            public void onConnectSuccess() {
                WILog.i(TAG, "connectToIp onConnectSuccess");
                view.setConnectStatus(true);
            }

            @Override
            public void onConnectFailed() {
                WILog.i(TAG, "connectToIp onConnectFailed");
                view.setConnectStatus(false);
            }

            @Override
            public void onFileTransmissionStart(FileTransmissionModel fileTransmissionModel) {
                view.updateFileTransmission(fileTransmissionModel);
            }

            @Override
            public void onFileTransmissionDownloading(FileTransmissionModel fileTransmissionModel) {
                view.updateFileTransmission(fileTransmissionModel);
            }

            @Override
            public void onFileTransmissionSuccess(FileTransmissionModel fileTransmissionModel) {
                view.updateFileTransmission(fileTransmissionModel);
                if (fileTransmissionModel.getFileName() != null && fileTransmissionModel.getFileName().endsWith(".apk")) {
//                    String destinationApkPath = fileTransmissionModel.getFileFullPath();
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.fromFile(new File(destinationApkPath)),
//                            "application/vnd.android.package-archive");
//                    getContext().startActivity(intent);

                    File apkFile = new File(fileTransmissionModel.getFileFullPath());
                    // 判断文件是否存在
                    if (!apkFile.exists()) {
                        return;
                    }
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setDataAndType(Uri.parse("file://" + apkFile.toString()),
                            "application/vnd.android.package-archive");
                    getContext().startActivity(i);
                }
            }

            @Override
            public void onFileTransmissionFailed(FileTransmissionModel fileTransmissionModel) {
                view.updateFileTransmission(fileTransmissionModel);
            }
        });
        WirelessInstallManager.getInstance().startConnect(ipString, port);
    }

    private Context getContext() {
        return view.getContext();
    }
}
