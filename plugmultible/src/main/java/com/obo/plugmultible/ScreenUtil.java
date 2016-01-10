package com.obo.plugmultible;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by obo on 16/1/10.
 */
public class ScreenUtil {

    public static Point getScreenSize(Activity activity) {

        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;//宽度
        int height = dm.heightPixels;//高度

        return new Point(width, height);
    }

}
