package com.me.obo.wirelessinstalllib.socket.transmission;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public interface FileTransmissionListener {
    void onFileTransmissionStart(FileTransmissionModel fileTransmissionModel);
    void onFileTransmissionDownloading(FileTransmissionModel fileTransmissionModel);
    void onFileTransmissionSuccess(FileTransmissionModel fileTransmissionModel);
    void onFileTransmissionFailed(FileTransmissionModel fileTransmissionModel);
}
