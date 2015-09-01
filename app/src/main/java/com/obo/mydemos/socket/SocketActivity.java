package com.obo.mydemos.socket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;
import com.obo.utils.network.socket.flowsend.OBSendFlow;

public class SocketActivity extends BaseActivity {
    public final static String ACTION = "com.obo.activity.intent.action.SocketActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
    }

    @Override
    public void onClick(View sender) {
        switch (sender.getId())
        {
            case R.id.socketSendBtn:

                OBSendFlow obSendFlow = new OBSendFlow("192.168.0.101",9898);
                String sendString = "Hello Socket";
                obSendFlow.sendFlow(sendString.getBytes());

                break;

            default:

                break;
        }
    }
}
