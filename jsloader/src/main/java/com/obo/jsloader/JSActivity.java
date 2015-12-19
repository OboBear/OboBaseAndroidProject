package com.obo.jsloader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        InputStream is = getResources().openRawResource(R.raw.city_list) ;
        List<ArrayList<String>>lists = null;
        PullParseXml p = new PullParseXml();
        try {
            lists = p.PullParseXML(is,5);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } finally {
            if (lists!=null)
            {
                String sss = "";
                for (int i=0;i<lists.size();i++)
                {
                    for (int j=0;j<lists.get(i).size();j++){
//                        System.out.println("value:"+lists.get(i).get(j));
                        sss += lists.get(i).get(j)+"\n";
                    }
                }
                editText1.setText(sss);
            }
        }


        is = getResources().openRawResource(R.raw.attractions_list);
        try {
            lists = p.PullParseXML(is,4);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } finally {
            if (lists!=null) {

                String sss = "";


                for (int i = 0; i < lists.size(); i++) {
                    for (int j = 0; j < lists.get(i).size(); j++) {
//                        System.out.println("value:" + lists.get(i).get(j));
                        sss += lists.get(i).get(j)+"\n";
                    }
                }
                editText2.setText(sss);
            }
        }
    }

}
