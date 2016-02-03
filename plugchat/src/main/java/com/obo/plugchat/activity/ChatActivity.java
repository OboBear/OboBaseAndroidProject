package com.obo.plugchat.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.obo.plugchat.R;
import com.obo.plugchat.adapter.ChatAdapter;
import com.obo.plugchat.model.ChatModel;

import java.util.ArrayList;

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
                if (chatModels.size() > 0)
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
        chatModels.add(new ChatModel(1,"你呀，我认识呀，不就是那个隔壁家小明嘛，23333"));
        chatModels.add(new ChatModel(0,"我晕，你不是机器人呀？"));
        chatModels.add(new ChatModel(1,"当然，本AI怎么会让你这种凡人看出来呢"));
        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_send: {
                ChatModel chatModel = new ChatModel();
                chatModel.setType(0);
                chatModel.setContent(edit_send.getText().toString());
                edit_send.setText("");

                chatModels.add(chatModel);
                chatAdapter.notifyDataSetChanged();

                listChat.smoothScrollToPosition(chatModels.size());
            }

            break;
        }

    }
}
