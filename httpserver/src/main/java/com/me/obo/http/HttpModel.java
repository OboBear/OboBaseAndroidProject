package com.me.obo.http;


import android.util.Log;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by obo on 2017/4/20.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class HttpModel {

    private static final String REQUETS_PARAM_KEY_CONTENT_LENGTH = "Content-Length";

    RequestHead requestHead;
    Map<String, String> messageHeadParams = new HashMap<>();
    Map<String, String> postParams = new HashMap<>();


    public static class RequestHead {
        public String method;
        public URLModel url;
        public String httpVersion;
    }

    public static class URLModel {
        String resourcePath;
        Map<String, String> getParams = new HashMap<>();

        public URLModel(String urlString) {
            if (urlString != null) {
                String[] urlSplit = urlString.split("\\?");
                decoMethodAndPath(urlSplit[0]);
                if (urlSplit.length > 1) {
                    decoGetParams(urlSplit[1]);
                }
            }
        }

        private void decoMethodAndPath(String url) {
            if (url.startsWith("/")) {
                resourcePath = url.substring(1,url.length());
            } else {
                resourcePath = url;
            }
        }

        private void decoGetParams(String getParamsString) {
            String[] getParamsStringSplit = getParamsString.split("&");

            for (String getParamString : getParamsStringSplit) {
                String[] getParamStringSplit = getParamString.split("=");
                getParams.put(getParamStringSplit[0], getParamStringSplit[1]);
            }
        }
    }

    public static void main(String [] args) {
        URLModel urlModel = new URLModel("getIndex/hhh/hello.html?sad=134&ghsan=nn");
        Log.i("","");;
    }




    public static class HttpModelBuilder {

        RequestHead requestHead;

        Map<String,String> messageHeadParams = new HashMap<>();
        Map<String, String> postParams = new HashMap<>();

        public HttpModelBuilder setRequestHead(String requestHeadString) {
            String [] requestHeadSplit = requestHeadString.split(" ");
            requestHead = new RequestHead();
            requestHead.method = requestHeadSplit[0];
            requestHead.url = new URLModel(requestHeadSplit[1]);
            requestHead.httpVersion = requestHeadSplit[2];
            return this;
        }

        public int getPostContentLength() {
            String requestParamContentLength = messageHeadParams.get(REQUETS_PARAM_KEY_CONTENT_LENGTH);
            if (requestParamContentLength != null) {
                int contentLength = Integer.parseInt(requestParamContentLength);
                return contentLength;
            }
            return 0;
        }

        public HttpModelBuilder setMessageHead(String messageHead) {
            String [] messageHeadSplit = messageHead.split(": ");
            messageHeadParams.put(messageHeadSplit[0],messageHeadSplit[1]);
            return this;
        }

        public HttpModelBuilder setPostParams(String postParamsString) {
            String [] postParamsSplit = postParamsString.split("&");
            for (String param : postParamsSplit) {
                String []paramSplit = param.split("=");
                postParams.put(paramSplit[0], paramSplit[1]);
            }
            return this;
        }

        public HttpModel build() {
            HttpModel httpModel = new HttpModel();
            httpModel.messageHeadParams = messageHeadParams;
            httpModel.requestHead = requestHead;
            httpModel.postParams = postParams;
            return httpModel;
        }
    }
}
