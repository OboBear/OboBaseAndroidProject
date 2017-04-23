package com.me.obo.wirelessinstallapk;

import android.content.Context;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class WIProtocol {
    public interface ConnectPresenter {
        void start(WIView view);
        void startConnect();
    }

    public interface WIView {
        Context getContext();
        void showHostIp(String hostIp);
        void updateFileTransmission(FileTransmissionModel fileTransmissionModel);
        void setConnectStatus(boolean connectStatus);
    }
}
