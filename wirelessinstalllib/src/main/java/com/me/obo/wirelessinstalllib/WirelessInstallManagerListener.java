package com.me.obo.wirelessinstalllib;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public interface WirelessInstallManagerListener {
    void onConnectSuccess();
    void onConnectFailed();
    void onFileTransmissionStart(FileTransmissionModel fileTransmissionModel);
    void onFileTransmissionDownloading(FileTransmissionModel fileTransmissionModel);
    void onFileTransmissionSuccess(FileTransmissionModel fileTransmissionModel);
    void onFileTransmissionFailed(FileTransmissionModel fileTransmissionModel);
}
