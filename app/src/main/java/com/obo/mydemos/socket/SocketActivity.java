package com.obo.mydemos.socket;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;
import com.obo.utils.network.MobileIpV4;
import com.obo.utils.network.socket.flowget.OBSocketFlowGet;
import com.obo.utils.network.socket.flowget.OBSocketFlowGetAgent;
import com.obo.utils.network.socket.flowsend.OBSendFlow;


public class SocketActivity extends BaseActivity implements OBSocketFlowGetAgent{
    public final static String ACTION = "com.obo.activity.intent.action.SocketActivity";

    EditText    editText;
    TextView    textView;

    OBSendFlow obSendFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        editText = $(R.id.editSocketInput);
        textView = $(R.id.textSocketResv);
        obSendFlow = new OBSendFlow("10.153.230.246",9898);

        String IP = MobileIpV4.getLocalIpAddress();

        textView.setText(IP);


    }

    Handler handler = new Handler();
    @Override
    public void onClick(View sender) {
        switch (sender.getId())
        {
            case R.id.socketSendBtn:

                String sendString = editText.getText().toString();
                obSendFlow.sendFlow(sendString.getBytes());

                break;

            case R.id.socketResvBtn:
                OBSocketFlowGet obSocketFlowGet = new OBSocketFlowGet(this,handler,9898);

                break;

            default:

                break;
        }
    }

    @Override
    public void getFlow(byte[] flow) {

        String stringGet = new String(flow);

        textView.setText(stringGet);
    }
}
