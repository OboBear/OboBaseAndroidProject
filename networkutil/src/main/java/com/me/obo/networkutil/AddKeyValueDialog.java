package com.me.obo.networkutil;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by obo on 16/6/13.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class AddKeyValueDialog extends Dialog {
    EditText mEtKey;
    EditText mEtValue;
    Button mBtnAdd;

    IAddKeyValue mAddKeyValue;

    public AddKeyValueDialog(Context context,IAddKeyValue addKeyValue) {
        super(context);
        mAddKeyValue = addKeyValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_key_value);
        initContentView();
    }


    private void initContentView() {
        mEtKey = (EditText) findViewById(R.id.et_key);
        mEtValue = (EditText) findViewById(R.id.et_value);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = mEtKey.getText().toString();
                String value = mEtValue.getText().toString();
                if (mAddKeyValue != null) {
                    mAddKeyValue.getResult(key,value);
                }
            }
        });
    }
}
