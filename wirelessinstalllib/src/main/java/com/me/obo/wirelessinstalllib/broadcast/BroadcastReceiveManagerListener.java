package com.me.obo.wirelessinstalllib.broadcast;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public interface BroadcastReceiveManagerListener {
    void onFailed(String errorMsg);
    void onReceiveMSG(String ip, int port);
}
