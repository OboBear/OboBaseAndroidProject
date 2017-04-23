package com.me.obo.pubnagtive;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import net.pubnative.library.model.AdFormat;
import net.pubnative.library.model.request.AdRequest;
import net.pubnative.library.model.response.Ad;
import net.pubnative.library.task.GetAdsTask;

import org.droidparts.concurrent.task.AsyncTaskResultListener;

import java.util.ArrayList;


public class PubNativeManager {

    private static final String TAG = "PubNativeManager";
    private static final String APP_KEY = "473d22bb2f1f17e8f6b6560e56f1fee328088c3df2b7cc4f5073fad408d371ea";
    private Context context;
    private AdRequest req;
    public static final int ADCount = 20;
    boolean mIsPubNativeLibLoaded = true;

    public PubNativeManager(Context context) {
        this.context = context;
        init();
    }

    public void initAdRequest() {
        try {

            req = new AdRequest(APP_KEY, AdFormat.NATIVE);
            req.fillInDefaults(context);

//			req.setParam("android_advertiser_id","38400000-8cf0-11bd-b23e-10b96e40000d");

            mIsPubNativeLibLoaded = true;

        } catch (Throwable e) {

            mIsPubNativeLibLoaded = false;
        }

        req.setParam("no_user_id", "1");
        req.setParam("bundle_id","me.talkyou.app.im.debug");
        req.setAdCount(ADCount);
    }

    public void init() {
        initAdRequest();
    }

    public void deInit() {
        context = null;
        req = null;
    }

    public void showAd() {
        new GetAdsTask<>(context, req, makeResultListener()).execute();
    }


    private <T extends Ad> AsyncTaskResultListener<ArrayList<Ad>> makeResultListener() {
        AsyncTaskResultListener<ArrayList<Ad>> resultListener = new AsyncTaskResultListener<ArrayList<Ad>>() {

            @Override
            public void onAsyncTaskSuccess(ArrayList<Ad> result) {
                Log.i("", "");
            }

            @Override
            public void onAsyncTaskFailure(Exception ex) {
                //TODO  gaojs getlist 0
                Log.i("", "");
            }
        };
        return resultListener;
    }


}
