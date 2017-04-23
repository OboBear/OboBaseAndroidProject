package com.me.obo.httpserver;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.me.obo.http.SocketHttp;
import com.me.obo.http.SocketHttpListener;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by obo on 2017/4/20.
 * Email:obo.lin@dingtone.me
 */

public class SocketHttpService extends IntentService {

    private static final String TAG = "SocketHttpService";

    public static void startService(Context context) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.me.obo.httpserver", "com.me.obo.httpserver.SocketHttpService");
        intent.setComponent(componentName);
        context.startService(intent);
        Log.i(TAG, "" );
    }

    public SocketHttpService() {
        super("SocketHttpService");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SocketHttpService(String name) {
        super(name);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"onHandleIntent");
        startSocketServer();
    }

    private void startSocketServer() {
        SocketHttp socketHttp = new SocketHttp();
        socketHttp.startServer(new SocketHttpListener() {
            @Override
            public InputStream getInputString(String filePath) {
                try {
                    return getAssets().open(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
