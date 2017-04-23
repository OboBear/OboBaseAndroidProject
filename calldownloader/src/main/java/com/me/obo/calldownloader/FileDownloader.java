package com.me.obo.calldownloader;

import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by obo on 16/9/15.
 * Email:obo.lin@dingtone.me
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class FileDownloader {

    public static final String TAG = FileDownloader.class.getSimpleName();

    OkHttpClient mOkHttpClient = new OkHttpClient();

    private FileDownloaderListener mFileDownloaderListener = null;

    public FileDownloader(FileDownloaderListener listener) {
        mFileDownloaderListener = listener;
    }
    /**
     * 下载文件
     * @param fileUrl 文件url
     * @param localPath 存储目标目录
     */
    public <T> void downLoadFile(String fileUrl,String localPath) {

        final File file = new File(localPath);

        final Request request = new Request.Builder().url(fileUrl).build();
        final Call call = mOkHttpClient.newCall(request);
        if (mFileDownloaderListener != null) {
            mFileDownloaderListener.onDownloadStart();
        }
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (mFileDownloaderListener != null) {
                    mFileDownloaderListener.onDonwloadFailed("" + e.getMessage());
                }
                Log.i("","");
            }

            @Override
            public void onResponse(Response response) throws IOException {

                    InputStream is = null;
                    byte[] buf = new byte[2048];
                    int len = 0;
                    FileOutputStream fos = null;
                    try {
                        long total = response.body().contentLength();
                        Log.e(TAG, "total------>" + total);
                        long current = 0;
                        is = response.body().byteStream();
                        fos = new FileOutputStream(file);
                        while ((len = is.read(buf)) != -1) {
                            current += len;
                            fos.write(buf, 0, len);
                            Log.e(TAG, "current------>" + current);
                            mFileDownloaderListener.onDonwloading(total, current);
                        }
                        fos.flush();
                        mFileDownloaderListener.onDownloadComplete(total);
                        Log.i("","");
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (IOException e) {
                            Log.e(TAG, e.toString());
                        }
                    }

            }
        }
        );
    }



}
