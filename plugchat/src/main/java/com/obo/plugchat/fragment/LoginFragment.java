package com.obo.plugchat.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obo.plugchat.R;
import com.obo.plugchat.activity.ChatActivity;

/**
 * 登录界面
 */
public class LoginFragment extends Fragment implements View.OnClickListener{


    View mMainView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_login, container, false);
        initViews();
        return mMainView;
    }


    private void initViews() {
        mMainView.findViewById(R.id.btn_login).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:
            Intent intent = new Intent();
            intent.setAction(ChatActivity.ACTION);
            startActivity(intent);
            break;
        }
    }
}
