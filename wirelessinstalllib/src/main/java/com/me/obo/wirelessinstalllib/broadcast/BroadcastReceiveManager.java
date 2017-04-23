package com.me.obo.wirelessinstalllib.broadcast;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class BroadcastReceiveManager {

    private static final String TAG = "BroadcastReceiveManager";

    BroadcastReceiveManagerListener mListener = null;

    private static class BroadcastReceiveManagerHolder {
        private static BroadcastReceiveManager instance = new BroadcastReceiveManager();
    }

    public static BroadcastReceiveManager getInstance() {
        return BroadcastReceiveManagerHolder.instance;
    }

    public void startReceive(BroadcastReceiveManagerListener listener) {
        mListener = listener;
        int port = 9988;//开启监听的端口
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];//存储发来的消息
        StringBuffer sbuf = new StringBuffer();
        try {
            //绑定端口的
            ds = new DatagramSocket(port);
            dp = new DatagramPacket(buf, buf.length);
            System.out.println("监听广播端口打开：");
            Log.i(TAG, "startReceive start receive ad port = " + port);
            ds.receive(dp);
            ds.close();
            int i;
            for(i=0;i<1024;i++){
                if(buf[i] == 0){
                    break;
                }
                sbuf.append((char) buf[i]);
            }
            Log.i(TAG, "startReceive received msg = " + sbuf.toString());
            Log.i(TAG, "startReceive revieced ip = " + dp.getAddress().getHostAddress());
            if (mListener != null) {
                mListener.onReceiveMSG( dp.getAddress().getHostAddress(), Integer.parseInt(sbuf.toString()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
            if (mListener != null) {
                mListener.onFailed(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (mListener != null) {
                mListener.onFailed(e.getMessage());
            }
        }
    }
}
