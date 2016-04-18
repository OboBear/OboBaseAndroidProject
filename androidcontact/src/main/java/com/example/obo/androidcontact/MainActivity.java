package com.example.obo.androidcontact;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newThread = new NewThread();
        newThread.start();

    }
    NewThread newThread;
    public void onClick(View view) {
        newThread.handler.sendEmptyMessage(6);
    }

    class NewThread extends Thread {
        public Handler handler ;

        @Override
        public void run() {
            super.run();
            // 子线程使用handler必须要主动去绑定到消息队列中
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Log.i("Thread","what"+msg.what);
                }
            };
            Looper.loop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 必须要关闭
        newThread.handler.getLooper().quit();
    }
}
