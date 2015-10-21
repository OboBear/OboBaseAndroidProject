package com.obo.mydemos.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.obo.activity.R;
import com.obo.activity.base.BaseActivity;

public class WebViewActivity extends BaseActivity {
    public final static String ACTION  = "com.obo.activity.intent.action.WebViewActivity";

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initContentView();
    }

    private void initContentView()
    {
        webView = $(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/webView/home.html");
    }

    @Override
    public void onClick(View sender) {

    }

}
