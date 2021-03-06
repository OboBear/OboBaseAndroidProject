package com.obo.plugmultible.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by obo on 16/1/10.
 */
public class Utils {

    public static String TAG = Utils.class.getSimpleName();
    public static String getNumbers(String originalString) {

        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(originalString);
        String all = matcher.replaceAll("");
        return all;
    }

    public static boolean isNumbers(String originalString) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(originalString);
        return matcher.matches();
    }


    public static double getApproximateValue(double original,int deg) {
        Log.i(TAG,"original/Math.pow(10,deg):"+original/Math.pow(10,deg));
        double result = ((int)(original/Math.pow(10,deg) + 0.5))*Math.pow(10,deg);

        return result;
    }

}
