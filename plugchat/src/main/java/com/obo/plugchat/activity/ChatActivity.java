package com.obo.plugchat.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.obo.plugchat.R;
import com.obo.plugchat.adapter.ChatAdapter;
import com.obo.plugchat.config.Config;
import com.obo.plugchat.model.ChatModel;
import com.obo.plugchat.network.ChatInterfaceClass;
import com.obo.plugchat.network.ChatResult;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String ACTION = "com.obo.plugcha.action.LoginActivity";


    ListView listChat;

    ChatAdapter chatAdapter;

    ArrayList<ChatModel> chatModels = new ArrayList<>();

    EditText edit_send;

    RelativeLayout layout_button_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_chat);
        edit_send = (EditText) findViewById(R.id.edit_send);
        listChat = (ListView) findViewById(R.id.list_chat_content);
        layout_button_input = (RelativeLayout) findViewById(R.id.layout_button_input);
        listChat.addOnLayoutChangeListener((v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
            if (chatModels.size() > 0 && oldBottom > bottom)
                listChat.smoothScrollToPosition(chatModels.size() - 1);
        });
        chatAdapter = new ChatAdapter(this, chatModels);
        listChat.setAdapter(chatAdapter);
        initDatas();
    }

    String[] firstChat = new String[]{
            "主人,我是您的私人机器人小喵,请问您需要我做点什么?",
            "总算是等到你了,人家一个喵好无聊的",
    };

    void initDatas() {
//        chatModels.add(new ChatModel(0,"你好！"));
        chatModels.add(new ChatModel(1, firstChat[(int) (Math.random() * 10) % 2]));
//        chatModels.add(new ChatModel(0,"猜猜我是谁？"));
//        chatModels.add(new ChatModel(1, "你呀，我认识呀，不就是那个隔壁家小明嘛，23333"));
//        chatModels.add(new ChatModel(0,"我晕，你不是机器人呀？"));
//        chatModels.add(new ChatModel(1, "当然，本AI怎么会让你这种凡人看出来呢"));
        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_send: {
                String sendText = edit_send.getText().toString();
                ChatModel chatModel = new ChatModel();
                chatModel.setType(0);
                chatModel.setContent(sendText);
                edit_send.setText("");
                chatModels.add(chatModel);
                chatAdapter.notifyDataSetChanged();
                listChat.smoothScrollToPosition(chatModels.size());

                sendChat(sendText);

                switch (sendText) {
                    case "相机": {
                        Intent intent = new Intent();
                        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 0);
                    }
                    break;
                    case "音乐":
//                        Intent it = new Intent(Intent.ACTION_MAIN);
//                        it.addCategory(Intent.CATEGORY_APP_MUSIC);
//                        startActivity(it);

//                        File audioFile = new File(Environment.getExternalStorageDirectory(), "123.mp3");
//                        Uri uri = Uri.parse(audioFile.getAbsolutePath());
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//// intent.addCategory(Intent.CATEGORY_APP_MUSIC);
//                        intent.setDataAndType(uri, "audio/*");
//                        startActivity(intent);

//                        if(android.os.Build.VERSION.SDK_INT>=15){
//                            Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,
//                                    Intent.CATEGORY_APP_MUSIC);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Min SDK 15
//                            startActivity(intent);
//                        }else{
//                            Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");//Min SDK 8
//                            startActivity(intent);
//                        }

                        break;
                    case "设置":
                        Intent settingIntent = new Intent(this, SettingActivity.class);
                        startActivityForResult(settingIntent, 1);
                        break;

                    case "清空":
                        chatModels.clear();
                        chatAdapter.notifyDataSetChanged();
//                        listChat.smoothScrollToPosition(chatModels.size());
                        break;
                }

                if (sendText.contains("播放")) {

                }
            }
            break;
        }

    }

    Handler handler = new Handler();


    private void sendChat(String sendString) {

        Log.i("", "result " + "sendChat");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatInterfaceClass.ChatInterface chatInterface = retrofit.create(ChatInterfaceClass.ChatInterface.class);

        try {
            sendString = new String(sendString.getBytes(), "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final Call<ChatResult> chatResultCall = chatInterface.getChatResult("1", sendString, "exampleusage_1231232", "json");


        WeakReference<ChatActivity>weakActivity = new WeakReference<>(this);
        HandlerThread handlerThread = new HandlerThread("");
        new Thread() {
            @Override
            public void run() {

                try {
                    retrofit2.Response<ChatResult> result = chatResultCall.execute();
                    final ChatResult chatResult = result.body();
                    if (chatResult != null) {
                        ChatActivity currentActivity = weakActivity.get();
                        if (currentActivity != null) {
                            currentActivity.runOnUiThread(()->{
                                String resultString = null;
                                try {
                                    resultString = new String(chatResult.getBotsay().getBytes(), "utf-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                                ChatModel chatModel = new ChatModel();
                                chatModel.setType(1);
                                if (resultString != null && resultString.length() > 0) {
                                    chatModel.setContent(resultString);

                                } else {
                                    chatModel.setContent("对不起,我正在学习中");
                                }
                                currentActivity.chatModels.add(chatModel);
                                currentActivity.chatAdapter.notifyDataSetChanged();
                                currentActivity.listChat.smoothScrollToPosition(chatModels.size());
                            });
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
