package com.me.obo.wirelessinstalllib.socket.commandConnect.model;

import java.io.Serializable;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class Command implements Serializable {

    public static final int NONE = 0;
    public static final int HEART_BEAT = 1;
    public static final int SEND_MESSAGE = 2;
    public static final int SEND_FILE = 3;

    private int command = 0;
    private String data;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
