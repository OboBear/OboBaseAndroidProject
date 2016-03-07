package com.obo.plugchat.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.obo.plugchat.R;
import com.obo.plugchat.adapter.ChatAdapter;
import com.obo.plugchat.model.ChatModel;
import com.obo.plugchat.network.ChatInterfaceClass;
import com.obo.plugchat.network.ChatResult;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

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
        listChat.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (chatModels.size() > 0 && oldBottom>bottom)
                listChat.smoothScrollToPosition(chatModels.size() - 1);
            }
        });
        chatAdapter = new ChatAdapter(this, chatModels);
        listChat.setAdapter(chatAdapter);

        initDatas();
    }


    void initDatas() {
        chatModels.add(new ChatModel(0,"你好！"));
        chatModels.add(new ChatModel(1,"你好呀！"));
        chatModels.add(new ChatModel(0,"猜猜我是谁？"));
        chatModels.add(new ChatModel(1, "你呀，我认识呀，不就是那个隔壁家小明嘛，23333"));
        chatModels.add(new ChatModel(0,"我晕，你不是机器人呀？"));
        chatModels.add(new ChatModel(1, "当然，本AI怎么会让你这种凡人看出来呢"));
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
            }
            break;
        }

    }

    Handler handler = new Handler();


    private void sendChat(String sendString) {

        Log.i("","result "+"sendChat");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://123.57.155.205/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatInterfaceClass.ChatInterface chatInterface = retrofit.create(ChatInterfaceClass.ChatInterface.class);

        try {
            sendString= new String(sendString.getBytes(),"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final Call<ChatResult>chatResultCall = chatInterface.getChatResult("1", sendString, "exampleusage_1231232", "json");

        new Thread(){

            @Override
            public void run() {
                Log.i("","result "+"Thread");
                try {
                    retrofit2.Response<ChatResult> result =  chatResultCall.execute();

                    final ChatResult chatResult = result.body();

                    Log.i("","result "+chatResult);

                    if (chatResult != null) {


                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                String resultString = null;
                                try {
                                    resultString = new String(chatResult.getBotsay().getBytes(),"utf-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                                ChatModel chatModel = new ChatModel();
                                chatModel.setType(1);
                                if (resultString != null && resultString.length() > 0) {
                                    chatModel.setContent(resultString);

                                }
                                else  {
                                    chatModel.setContent("对不起,我正在学习中");
                                }
                                chatModels.add(chatModel);
                                chatAdapter.notifyDataSetChanged();
                                listChat.smoothScrollToPosition(chatModels.size());
                            }
                        });

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
}
