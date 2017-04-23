package com.me.obo.http;

/**
 * Created by obo on 2017/4/20.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class HttpModelManager {

    private static class HttpModelManagerHolder {
        private static HttpModelManager instance = new HttpModelManager();
    }

    public static HttpModelManager getInstance() {
        return HttpModelManagerHolder.instance;
    }

    public HttpModel getHttpModelWithRequestString(String requestString) {
        HttpModel httpModel = new HttpModel();
        return httpModel;
    }


}
