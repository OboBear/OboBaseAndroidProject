package com.obo.plugmultible.utils;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by obo on 16/1/10.
 */
public class ScreenUtil {

    public static int ScreenWith = 0;
    public static int ScreenHeight = 0;

    public static Point initScreenSize(Activity activity) {

        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        ScreenWith = dm.widthPixels;//宽度
        ScreenHeight = dm.heightPixels;//高度

        return new Point(ScreenWith, ScreenHeight);
    }

}
