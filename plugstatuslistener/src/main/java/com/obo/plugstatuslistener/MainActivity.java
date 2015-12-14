package com.obo.plugstatuslistener;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //判断是否存在蓝牙接口
//        if (isBluetoothAvaliable()){
//            //判断是否打开蓝牙
//            if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
//                BluetoothAdapter.getDefaultAdapter().enable();
//            }
//            //注册蓝牙监听的相关操作
//            registerBoradcastReceiver();
//        }


//        openGPSSettings();


//        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
//        audioManager.setMicrophoneMute(true);


//        MediaRecorder mediaRecorder = new MediaRecorder();
//// 第1步：设置音频来源（MIC表示麦克风）
//        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
////第2步：设置音频输出格式（默认的输出格式）
//        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
////第3步：设置音频编码方式（默认的编码方式）
//        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
////创建一个临时的音频输出文件
//        File audioFile = null;
//        try {
//            audioFile = File.createTempFile("test", ".amr");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////第4步：指定音频输出文件
//        mediaRecorder.setOutputFile(audioFile.getAbsolutePath());
////第5步：调用prepare方法
//        try {
//            mediaRecorder.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////第6步：调用start方法开始录音
//        try {
//            mediaRecorder.start();
//        }
//        catch (IllegalStateException i) {
//
//            Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
//
//            startActivityForResult(intent, 0); //此为设置完成后返回到获取界面
//        }


//        this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
//        Manifest.permission.ACCESS_COARSE_LOCATION

        boolean canGPSLocation = (PackageManager.PERMISSION_GRANTED == this.checkPermission(Manifest.permission.RECORD_AUDIO,Binder.getCallingPid(),Binder.getCallingUid()));
//        boolean canBaseLocation = (PackageManager.PERMISSION_GRANTED == this.checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,Binder.getCallingPid(),Binder.getCallingUid()));

        if (canGPSLocation) {

        }
        else {
            Toast.makeText(this,"用户尚未开启权限",Toast.LENGTH_LONG).show();
        }

    }


    private boolean isBluetoothAvaliable() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }

    private void registerBoradcastReceiver() {

        IntentFilter stateChangeFilter = new IntentFilter(
                BluetoothAdapter.ACTION_STATE_CHANGED);
        IntentFilter connectedFilter = new IntentFilter(
                BluetoothDevice.ACTION_ACL_CONNECTED);
        IntentFilter disConnectedFilter = new IntentFilter(
                BluetoothDevice.ACTION_ACL_DISCONNECTED);
        registerReceiver(stateChangeReceiver, stateChangeFilter);
        registerReceiver(stateChangeReceiver, connectedFilter);
        registerReceiver(stateChangeReceiver, disConnectedFilter);
    }

    private BroadcastReceiver stateChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //蓝牙连接成功
            if (BluetoothDevice.ACTION_ACL_CONNECTED == action) {
                Toast.makeText(MainActivity.this, "ACTION_ACL_CONNECTED", Toast.LENGTH_SHORT).show();
            }
            //蓝牙断开连接
            if (BluetoothDevice.ACTION_ACL_DISCONNECTED == action) {
                Toast.makeText(MainActivity.this, "ACTION_ACL_DISCONNECTED", Toast.LENGTH_SHORT).show();
            }
            //蓝牙状态改变（打开、关闭）
            if (BluetoothAdapter.ACTION_STATE_CHANGED == action) {
                Toast.makeText(MainActivity.this, "ACTION_STATE_CHANGED", Toast.LENGTH_SHORT).show();
            }
        }
    };




    private void openGPSSettings() {
        LocationManager alm = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);
        if (alm
                .isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "GPS模块正常", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Toast.makeText(this, "请开启GPS！", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);

        startActivityForResult(intent, 0); //此为设置完成后返回到获取界面

    }




}
