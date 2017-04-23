package com.me.obo.pubnagtive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import net.pubnative.library.request.PubnativeRequest;
import net.pubnative.library.request.model.PubnativeAdModel;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                PubNativeManager pubNativeManager = new PubNativeManager(MainActivity.this);
//                pubNativeManager.showAd();
//            }
//        }.start();


//        new Thread() {
//
//            @Override
//            public void run() {
//                super.run();
//                try {
////                    String url = run2("https://api.pubnative.net/api/partner/v2/promotions/native?app_token=473d22bb2f1f17e8f6b6560e56f1fee328088c3df2b7cc4f5073fad408d371ea&bundle_id=me.talkyou.app.im.debug&icon_size=80x80&banner_size=1200x627&os=android&os_version=4.4&device_model=Nexus5&no_user_id=1");
//                    String url = run2("https://api.pubnative.net/api/partner/v2/promotions/native");
//                    Log.i("", "url");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//
//            }
//
//
//        }.start();


        PubnativeRequest request = new PubnativeRequest();
        request.setParameter(PubnativeRequest.Parameters.APP_TOKEN, "473d22bb2f1f17e8f6b6560e56f1fee328088c3df2b7cc4f5073fad408d371ea");
//        request.setTestMode(true);
        request.start(this, new PubnativeRequest.Listener() {
            @Override
            public void onPubnativeRequestSuccess(PubnativeRequest request, List<PubnativeAdModel> ads) {
                // TODO Auto-generated method stub
                Log.i("","");
            }

            @Override
            public void onPubnativeRequestFailed(PubnativeRequest request, Exception ex) {
                // TODO Auto-generated method stub
                Log.i("","");
            }
        });




    }

    String run2(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
