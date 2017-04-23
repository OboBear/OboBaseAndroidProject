package com.me.obo.wirelessinstalllib.command;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class CommandManager {
    public static final int NONE = 0;
    public static final int HEART_BEAT = 1;
    public static final int SEND_MESSAGE = 2;
    public static final int SEND_FILE = 3;

    private static final String HEART_BEAT_PREFIX = "__HEART_BEAT__";
    private static final String SEND_MESSAGE_PREFIX = "__SEND_MESSAGE__";
    private static final String SEND_FILE_PREFIX = "__SEND_FILE__";

    public static int getCommand(String inputString) {
        int command = NONE;
        if (inputString != null) {
            if (inputString.startsWith(HEART_BEAT_PREFIX)) {
                command = HEART_BEAT;
            } else if (inputString.startsWith(SEND_MESSAGE_PREFIX)) {
                command = SEND_MESSAGE;
            } else if (inputString.startsWith(SEND_FILE_PREFIX)) {
                command = SEND_FILE;
            }
        }
        return command;
    }

}
