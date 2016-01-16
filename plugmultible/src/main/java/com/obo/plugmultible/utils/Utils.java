package com.obo.plugmultible.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by obo on 16/1/10.
 */
public class Utils {

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
}
