package com.me.obo.wirelessinstalllib.socket.transmission;

import android.os.Environment;

import com.me.obo.wirelessinstalllib.socket.transmission.model.FileTransmissionModel;
import com.me.obo.wirelessinstalllog.WILog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class FileTransmission {
    private static final String TAG = "FileTransmission";

    FileTransmissionModel fileTransmissionModel;

    private Socket fileSocket = null;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    FileOutputStream fout = null;

    FileTransmissionListener fileTransmissionListener = null;

    public FileTransmission(FileTransmissionModel fileTransmissionModel) {
        this.fileTransmissionModel = fileTransmissionModel;
    }

    public void start(FileTransmissionListener fileTransmissionListener) {
        this.fileTransmissionListener = fileTransmissionListener;
        new Thread() {
            @Override
            public void run() {
                super.run();

                fileSocket = new Socket();
                try {
                    fileSocket.connect(new InetSocketAddress(fileTransmissionModel.getHostIp()
                            ,fileTransmissionModel.getPort()));
                    dis = new DataInputStream(fileSocket.getInputStream());
                    receiveFile(dis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    // 创建一个文件夹对象，赋值为外部存储器的目录
    File sdcardDir = Environment.getExternalStorageDirectory();
    private void receiveFile(DataInputStream dis) {

//        String filePath = sdcardDir + "/wireless/apps";
        File file = new File(fileTransmissionModel.getDestinationFilePath());
        if (!file.exists()) {
            WILog.i(TAG, "receiveFile mkdir filePath = " + fileTransmissionModel.getDestinationFilePath());
            file.mkdirs();
        }
        if (fileTransmissionListener != null) {
            fileTransmissionListener.onFileTransmissionStart(fileTransmissionModel);
        }
        try {
            FileOutputStream fout = new FileOutputStream(fileTransmissionModel.getFileFullPath());
            byte[] inputByte = new byte[1024];
            int length = 0;

            System.out.println("start receiving...");
            while (true) {
                if (dis != null) {
                    length = dis.read(inputByte, 0, inputByte.length);
                }
                WILog.i(TAG, "receiveFile length = " + length);
                if (length == -1) {
                    break;
                }
                System.out.println(length);
                fout.write(inputByte, 0, length);
                fout.flush();
                fileTransmissionModel.setCurrentSize(fileTransmissionModel.getCurrentSize() + length);
                if (fileTransmissionListener != null) {
                    fileTransmissionListener.onFileTransmissionDownloading(fileTransmissionModel);
                }
            }
            WILog.i(TAG, "receiveFile success");
            if (fileTransmissionListener != null) {
                fileTransmissionListener.onFileTransmissionSuccess(fileTransmissionModel);
            }
        } catch (Exception e) {
            WILog.i(TAG, "Error");
            e.printStackTrace();
            if (fileTransmissionListener != null) {
                fileTransmissionListener.onFileTransmissionFailed(fileTransmissionModel);
            }
        }
    }
}
