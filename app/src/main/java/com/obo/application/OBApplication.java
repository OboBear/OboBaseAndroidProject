package com.obo.application;

import android.app.Application;

import java.util.Objects;

/**
 * Created by obo on 15/8/24.
 */
public class OBApplication extends Application {
    private Object shareData;
    public void setShareData(Object shareData)
    {
        this.shareData = shareData;
    }
    public Object getShareData()
    {
        return this.shareData;
    }
}
