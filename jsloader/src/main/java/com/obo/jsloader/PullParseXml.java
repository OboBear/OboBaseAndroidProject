package com.obo.jsloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by obo on 15/12/19.
 */

public class PullParseXml {

    public static String TAG = PullParseXml.class.getCanonicalName();

    public List<ArrayList<String>> PullParseXML(InputStream in,int paramNumber) throws XmlPullParserException {

        List<ArrayList<String>> list = null;

        //构建XmlPullParserFactory
        try {
            XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
            //获取XmlPullParser的实例
            XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
            //设置输入流  xml文件
            xmlPullParser.setInput(in, "UTF-8");
            //开始
            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();

                switch (eventType) {
                    //文档开始
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<>();
                        Log.i(TAG, "XmlPullParser.START_DOCUMENT");
                        break;
                    //开始节点
                    case XmlPullParser.START_TAG:
                        if ("tr".equals(nodeName)) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            for (int i = 0; i < paramNumber; i++) {
                                while (!"td".equals(xmlPullParser.getName())) {
                                    xmlPullParser.next();
                                }
                                String text = xmlPullParser.nextText();
                                arrayList.add(text);
                                xmlPullParser.next();
                            }
                            list.add(arrayList);
                        }
                        break;
                    //结束节点
                    case XmlPullParser.END_TAG:

                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}


