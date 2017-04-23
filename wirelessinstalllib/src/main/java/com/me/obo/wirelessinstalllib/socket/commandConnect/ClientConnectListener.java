package com.me.obo.wirelessinstalllib.socket.commandConnect;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public interface ClientConnectListener {
    void onConnectSuccess();
    void onConnectFailed();
    void onHeartBeat();
    void onFileTransmissionRequest(FileTransmissionModel fileTransmissionModel);

}
