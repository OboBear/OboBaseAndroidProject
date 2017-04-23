package com.me.obo.networkutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.me.obo.networkutil.DataManager.DataManager;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    TextView mTvJson;

    Button mBtnAddQuerry;
    Button mBtnAddPost;
    Button mBtnSend;

    AddKeyValueDialog mAddKeyValueDialog = null;

    LayoutInflater mLayoutInflater;

    LinearLayout mLayoutQuerry;
    LinearLayout mLayoutPost;

    EditText mEtUrl;

    EditText mEtBackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_network);
        mLayoutInflater = LayoutInflater.from(this);

        mEtUrl = (EditText) findViewById(R.id.et_url);
        mEtBackName = (EditText) findViewById(R.id.et_result_name);
        mTvJson = (TextView) findViewById(R.id.tv_hello);
        mBtnAddQuerry = (Button) findViewById(R.id.btn_querry);
        mBtnAddPost = (Button) findViewById(R.id.btn_post);
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mLayoutQuerry = (LinearLayout) findViewById(R.id.layout_querry);
        mLayoutPost = (LinearLayout) findViewById(R.id.layout_post);

        mBtnAddQuerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddKeyValueDialog = new AddKeyValueDialog(MainActivity.this, new IAddKeyValue() {
                    @Override
                    public void getResult(String key, String value) {

                        final View viewKeyValue = mLayoutInflater.inflate(R.layout.item_key_value, null);
                        viewKeyValue.setTag(new String[]{key, value});
                        ((TextView) viewKeyValue.findViewById(R.id.tv_key)).setText(key);
                        ((TextView) viewKeyValue.findViewById(R.id.tv_value)).setText(value);
                        viewKeyValue.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mLayoutQuerry.removeView(viewKeyValue);
                            }
                        });
                        mLayoutQuerry.addView(viewKeyValue);
                        mAddKeyValueDialog.cancel();
                    }
                });
                mAddKeyValueDialog.show();
            }
        });

        mBtnAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddKeyValueDialog = new AddKeyValueDialog(MainActivity.this, new IAddKeyValue() {
                    @Override
                    public void getResult(String key, String value) {

                        final View viewKeyValue = mLayoutInflater.inflate(R.layout.item_key_value, null);
                        viewKeyValue.setTag(new String[]{key, value});
                        ((TextView) viewKeyValue.findViewById(R.id.tv_key)).setText(key);
                        ((TextView) viewKeyValue.findViewById(R.id.tv_value)).setText(value);
                        viewKeyValue.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mLayoutPost.removeView(viewKeyValue);
                            }
                        });
                        mLayoutPost.addView(viewKeyValue);
                        mAddKeyValueDialog.cancel();
                    }
                });
                mAddKeyValueDialog.show();
            }
        });

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEtBackName.getText().toString().trim().length() == 0) {
                    showToast("请为网络返回结果命名");
                    return;
                }

                Map<String, String> postParams = new HashMap<String, String>();

                for (int i = 0; i < mLayoutPost.getChildCount(); i++) {
                    View childView = mLayoutPost.getChildAt(i);
                    String[] keyValue = (String[]) childView.getTag();

                    postParams.put(keyValue[0],keyValue[1]);
                }
                String urlString = mEtUrl.getText().toString();
                loadData(urlString,postParams);
            }
        });
    }

    private void loadData(String urlString,Map<String, String> postParams) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        // post类型
        if (postParams.size()>0) {

            FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
            for (String key : postParams.keySet()) {
                formEncodingBuilder.add(key,postParams.get(key));
            }
            RequestBody formBody = formEncodingBuilder.build();
            builder.post(formBody);
        }

        Request request =builder.url(urlString).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                Log.i("", "");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String result = response.body().string();
                final String tt = decoJsonString(result, 1);

                DataManager.addData(mEtBackName.getText().toString().trim(),result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvJson.setText(mEtBackName.getText().toString().trim() +":\n" + tt);
                    }
                });
            }
        });
    }

    private String decoJsonString(String jsonString, int stage) {
        StringBuilder stringBuilder = new StringBuilder();
        String emp = String.format("%-" + stage * 2 + "s", "");
        try {
            JSONObject json = new JSONObject(jsonString);
            Iterator<String> iterator = json.keys();
            stringBuilder.append("\n");
            stringBuilder.append(emp);
            stringBuilder.append("{\n");
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = json.get(key).toString();
                stringBuilder.append(emp + "  ");
                stringBuilder.append(key + ":" + decoJsonString(value, stage + 1));
                if (iterator.hasNext()) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append(emp);
            stringBuilder.append("}");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                JSONArray jsonArray = new JSONArray(jsonString);
                if (jsonArray.length() == 0) {
                    stringBuilder.append("[]");
                } else {
                    stringBuilder.append("\n");
                    stringBuilder.append(emp);
                    stringBuilder.append("[\n");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        stringBuilder.append(emp);
                        stringBuilder.append(decoJsonString(jsonArray.get(i).toString(), stage + 1));
                        if (i != jsonArray.length() - 1) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(emp);
                    stringBuilder.append("]");
                }

            } catch (JSONException e1) {
                e1.printStackTrace();

                stringBuilder.append(jsonString);
            }
        }
        return stringBuilder.toString();
    }


    private void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
