package com.me.obo.http;

import java.io.InputStream;

/**
 * Created by obo on 2017/4/23.
 * Email:obo.lin@dingtone.me
 */

public interface SocketHttpListener {
    InputStream getInputString(String filePath);
}
