package com.obo.plugwebviewswith;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.io.InputStream;

public class WebViewSwithActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    EditText editText;

    boolean modeFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_swith);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        editText = (EditText) findViewById(R.id.editText);

        try {

            InputStream in = getAssets().open("HtmlModule/module");
            int size = in.available();
            byte []buffer = new byte[size];
            in.read(buffer);
            in.close();
            String te = new String(buffer,"UTF-8");

            editText.setText(te);

        } catch (Exception e) {

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnSwith:

                if (modeFlag) {

                    webView.setVisibility(View.GONE);
                    editText.setVisibility(View.VISIBLE);
                } else {

                    webView.setVisibility(View.VISIBLE);
                    webView.loadDataWithBaseURL(null, editText.getText().toString(), "text/html", "utf-8", null);
                    editText.setVisibility(View.GONE);
                }
                modeFlag = !modeFlag;
                break;
        }
    }
}
