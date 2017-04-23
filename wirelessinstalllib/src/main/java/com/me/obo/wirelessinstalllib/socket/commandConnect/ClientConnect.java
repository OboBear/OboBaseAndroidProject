package com.me.obo.wirelessinstalllib.socket.commandConnect;

import com.google.gson.Gson;
import com.me.obo.wirelessinstalllib.command.CommandManager;
import com.me.obo.wirelessinstalllib.socket.commandConnect.model.Command;
import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;
import com.me.obo.wirelessinstalllog.WILog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class ClientConnect {
    private static final String TAG = "ClientConnect";

    private Socket socket;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private boolean bConnected = false;
    private long lastHeartBeatTime = 0;
    private static final int TIMEOUT_TIME = 10 * 1000;

    private ClientConnectListener clientConnectListener = null;

    public ClientConnect(ClientConnectListener clientConnectListener) {
        this.clientConnectListener = clientConnectListener;
    }

    public boolean connect(String hostIp, int port) {
        try {
            socket = new Socket(hostIp, port);
            socket.setSoTimeout(TIMEOUT_TIME);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            bConnected = true;
            startListener();
            if (clientConnectListener != null) {
                clientConnectListener.onConnectSuccess();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            WILog.e(TAG, "connect connect error");
            if (clientConnectListener != null) {
                clientConnectListener.onConnectFailed();
            }
        }

        return false;
    }

    public void startListener() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (bConnected) {
                    try {
                        String str = dis.readUTF();
                        WILog.i(TAG, "startListener str = " + str);
                        decoIncomeMsg(str);
                    } catch (IOException e) {
                        WILog.i(TAG, "startListener error");
                        e.printStackTrace();
                        connectError();
                        return;
                    }
                }
            }
        }.start();
    }

    private void connectError() {
        bConnected = false;
        if (clientConnectListener != null) {
            clientConnectListener.onConnectFailed();
        }

        try {
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void decoIncomeMsg(String msg) {
        Gson gson = new Gson();
        try {
            Command command = gson.fromJson(msg, Command.class);
            switch (command.getCommand()) {
                case Command.HEART_BEAT:
                    lastHeartBeatTime = System.currentTimeMillis();
                    if (clientConnectListener != null) {
                        clientConnectListener.onHeartBeat();
                    }
                    break;
                case Command.SEND_FILE:
                    if (clientConnectListener != null) {
                        FileTransmissionModel fileTransmissionModel = gson.fromJson(command.getData(), FileTransmissionModel.class);
                        clientConnectListener.onFileTransmissionRequest(fileTransmissionModel);
                    }
                    break;
                case Command.NONE:
                default:
                    break;
            }
        } catch (Exception e) {
            WILog.e(TAG, "decoIncomeMsg parse error e = " + e.getMessage());
        }
    }

    public void send(String sendMsg) {
        if (dos != null) {
            try {
                dos.write(sendMsg.getBytes(), 0, sendMsg.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void disconnect() {

    }
}
