package com.me.obo.hyprmxtest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.hyprmx.android.activities.HyprMXActivity;
import com.hyprmx.android.sdk.HyprMXHelper;
import com.hyprmx.mediate.HyprMediate;
import com.hyprmx.mediate.HyprMediateError;
import com.hyprmx.mediate.HyprMediateListener;
import com.hyprmx.mediate.HyprMediateReward;

import java.io.IOException;

import rx.Observable;

public class MainActivity extends AppCompatActivity implements  HyprMediateListener{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HyprMXHelper h;
        HyprMXActivity a;

        Activity activity = this; // Must be your main Activity.
        HyprMediateListener listener = this; // This guide assumes that this is also your main Activity.

        new Thread() {
            @Override
            public void run() {
                super.run();
                String hyprAPIToken = "9d61812f-1b26-49fc-b71f-be701a2532a5";
                String hyprUserId = "71089584";
                try {
                    hyprUserId= AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
                Log.i(TAG,"hyprUserId = " + hyprUserId);
                HyprMediate.getInstance().initialize(activity, hyprAPIToken, hyprUserId, listener);
            }
        }.start();
    }

    @Override
    public void hyprMediateCanShowAd(boolean b) {
        Log.i(TAG, "hyprMediateCanShowAd = " + b);
        if (b) {
            HyprMediate.getInstance().showAd();
        }
    }

    @Override
    public void hyprMediateRewardDelivered(HyprMediateReward hyprMediateReward) {
        Log.d(TAG, "User earned " + hyprMediateReward.virtualCurrencyAmount() + " " + hyprMediateReward.virtualCurrencyName());
    }

    @Override
    public void hyprMediateErrorOccurred(HyprMediateError hyprMediateError) {
        Log.d(TAG, hyprMediateError.toString());
    }

    @Override
    public void hyprMediateStartedDisplaying() {
        Log.i(TAG,"hyprMediateStartedDisplaying");
    }

    @Override
    public void hyprMediateFinishedDisplaying() {
        Log.i(TAG,"hyprMediateFinishedDisplaying");
    }


    public void onClick(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
