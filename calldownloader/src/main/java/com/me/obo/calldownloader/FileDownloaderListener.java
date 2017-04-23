package com.me.obo.calldownloader;

/**
 * Created by obo on 2017/2/25.
 * Email:obo.lin@dingtone.me
 */

public interface FileDownloaderListener {
    void onDownloadComplete(long totalSize);
    void onDonwloading(long totalSize,long downloaded);
    void onDownloadStart();
    void onDonwloadFailed(String msg);

}
