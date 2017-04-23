package com.me.obo.ffmpegdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {

    Button btn_translate;
    EditText et_input_name;
    EditText et_output_name;

    String sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String fileName = "ffmpeg2";
//    String fileName = "ffmpeg";
    String fileName = "Hello";
//    String fileName = "ffmpeg-pie";
    String wrongVideoPath = sdCardPath + "/" + "_test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_input_name = (EditText) findViewById(R.id.et_input_name);
        et_output_name = (EditText) findViewById(R.id.et_output_name);
        btn_translate = (Button) findViewById(R.id.btn_translate);

        String dataFilePath = "data/data/" + getPackageName();
        File dataFile = new File(dataFilePath);

        
        final String destinationPath = dataFilePath + "/" + fileName;
        if (dataFile.exists()) {
            Log.i("", "");
        }


        try {
            InputStream inputStream = getResources().getAssets().open(fileName);
            FileOutputStream fout = new FileOutputStream(destinationPath, false);

            byte[] buffer = new byte[1024];
            int count;

            while ((count = inputStream.read(buffer)) != -1) {

                fout.write(buffer, 0, count);
            }
            inputStream.close();
            fout.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isE = new File(destinationPath).setExecutable(true, true);

        btn_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String inputFileName = wrongVideoPath + "/" + et_input_name.getText().toString();
                final String ouputFileName = wrongVideoPath + "/" + et_output_name.getText().toString();

//                File inputFile = new File(inputFileName);
//                if (!inputFile.exists()) {
//                    Log.e("e", "inputFile not exists");
//                    return;
//                }
//                if (!new File(destinationPath).exists()) {
//                    Log.e("e", "ffpegPath not exists");
//                    return;
//                }

                System.out.print("");
                Runtime runtime = Runtime.getRuntime();
                try {

//                    Process process = runtime.exec(destinationPath + " -i " + inputFileName + " -acodec aac  -vcodec mpeg4  -f mp4 " + ouputFileName);
//                    Process process = runtime.exec(destinationPath + " -i " + inputFileName + "  " + ouputFileName);
//                    Process process = runtime.exec(destinationPath + " --help " );
//                    Process process = runtime.exec(destinationPath + " -formats ");
                    Process process = runtime.exec(destinationPath);

                    try {
                        process.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String error = convertStreamToString(process.getErrorStream());

                    String output = convertStreamToString(process.getInputStream());
                    System.out.print("12e");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

    }


    public String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();


        String line = null;

        try {

            while ((line = reader.readLine()) != null) {

                sb.append(line + "/n");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                is.close();

            } catch (IOException e) {

                e.printStackTrace();

            }


        }
        return sb.toString();
    }


}
