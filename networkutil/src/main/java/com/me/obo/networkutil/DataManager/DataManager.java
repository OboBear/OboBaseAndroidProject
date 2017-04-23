package com.me.obo.networkutil.DataManager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by obo on 16/6/14.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class DataManager implements Serializable {
    private static Map<String,String>data = new HashMap<>();

    public static Map<String, String> getData() {
        return data;
    }

    public static void setData(Map<String, String> data) {
        DataManager.data = data;
    }

    public static void addData(String key,String value) {
        data.put(key,value);
    }


}
