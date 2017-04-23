package com.me.obo.wirelessinstalllib;

import android.os.Environment;

import com.me.obo.wirelessinstalllib.socket.commandConnect.ClientConnect;
import com.me.obo.wirelessinstalllib.socket.commandConnect.ClientConnectListener;
import com.me.obo.wirelessinstalllib.socket.transmission.FileTransmission;
import com.me.obo.wirelessinstalllib.socket.transmission.FileTransmissionListener;
import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;
import com.me.obo.wirelessinstalllog.WILog;

import java.io.DataInputStream;
import java.io.File;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */
public class WirelessInstallManager {
    private static final String TAG = "WirelessInstallManager";

    private String hostIp = null;
    private WirelessInstallManagerListener wirelessInstallManagerListener = null;

    private static class WirelessInstallManagerHolder {
        private static WirelessInstallManager instance = new WirelessInstallManager();
    }

    public static WirelessInstallManager getInstance() {
        return WirelessInstallManagerHolder.instance;
    }

    public void setWirelessInstallManagerListener(WirelessInstallManagerListener wirelessInstallManagerListener) {
        this.wirelessInstallManagerListener = wirelessInstallManagerListener;
    }

    public void startConnect(final String hostIp, final int port) {
        this.hostIp = hostIp;
        new Thread() {
            @Override
            public void run() {
                super.run();
                ClientConnect autoConnect = new ClientConnect(new ClientConnectListener() {
                    @Override
                    public void onHeartBeat() {
                        WILog.i(TAG, "startConnect onHeartBeat");
                    }
                    @Override
                    public void onFileTransmissionRequest(FileTransmissionModel fileTransmissionModel) {
                        fileTransmission(fileTransmissionModel);
                    }

                    @Override
                    public void onConnectSuccess() {
                        if (wirelessInstallManagerListener != null) {
                            wirelessInstallManagerListener.onConnectSuccess();
                        }
                    }

                    @Override
                    public void onConnectFailed() {
                        if (wirelessInstallManagerListener != null) {
                            wirelessInstallManagerListener.onConnectFailed();
                        }
                    }
                });
                autoConnect.connect(hostIp, port);
            }
        }.start();
    }

    File sdcardDir = Environment.getExternalStorageDirectory();


    /**
     *
     * @param fileTransmissionModel
     */
    private void fileTransmission(FileTransmissionModel fileTransmissionModel) {
        WILog.i(TAG, "fileTransmission fileName = " + fileTransmissionModel.getFileName()
                + " ; fileSize = " + fileTransmissionModel.getFileSize()
                + " ; port = " + fileTransmissionModel.getPort()
                + " ; sha = " + fileTransmissionModel.getSha()
                + " ; hostIp = " + hostIp );
        fileTransmissionModel.setHostIp(hostIp);
        String filePath = sdcardDir + "/wireless/apps";
        fileTransmissionModel.setDestinationFilePath(filePath);
        FileTransmission fileTransmission = new FileTransmission(fileTransmissionModel);
        fileTransmission.start(new FileTransmissionListener() {
            @Override
            public void onFileTransmissionStart(FileTransmissionModel fileTransmissionModel) {
                if (wirelessInstallManagerListener != null) {
                    wirelessInstallManagerListener.onFileTransmissionStart(fileTransmissionModel);
                }
            }

            @Override
            public void onFileTransmissionDownloading(FileTransmissionModel fileTransmissionModel) {
                if (wirelessInstallManagerListener != null) {
                    wirelessInstallManagerListener.onFileTransmissionDownloading(fileTransmissionModel);
                }
            }

            @Override
            public void onFileTransmissionSuccess(FileTransmissionModel fileTransmissionModel) {
                WILog.i(TAG, "onFileTransmissionSuccess fileName = " + fileTransmissionModel.getFileName());
                if (wirelessInstallManagerListener != null) {
                    wirelessInstallManagerListener.onFileTransmissionSuccess(fileTransmissionModel);
                }
            }

            @Override
            public void onFileTransmissionFailed(FileTransmissionModel fileTransmissionModel) {
                if (wirelessInstallManagerListener != null) {
                    wirelessInstallManagerListener.onFileTransmissionFailed(fileTransmissionModel);
                }
            }
        });
    }

}
