package com.me.obo.noactivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView tv_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_t = (TextView) findViewById(R.id.tv_t);
//        changeIcon();
//        jumpOther();
//        hidBack();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT, PackageManager.DONT_KILL_APP);

//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

//        setContentView(R.layout.activity_main);
//        Toast.makeText(this,"hell",Toast.LENGTH_LONG).show();
//        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
//        PackageManager p = getPackageManager();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

    }

    @Override
    protected void onPause() {
        super.onPause();
//        PackageManager p = getPackageManager();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        PackageManager p = getPackageManager();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }


    static int i=0;

    private void changeIcon() {

        ComponentName s = getComponentName();
        System.out.print(""+s);
        tv_t.setText(""+getComponentName().toString());
        s.getClassName();
        s = new ComponentName(getBaseContext(), "com.me.obo.noactivity.MainActivity2");



//        try {
//            String className = s.getClassName();
//            Class classPa = Class.forName(className);
//            Intent intent = new Intent(this,classPa);
//            startActivity(intent);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        if (i < 1) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setAction("android.intent.MainActivity2");
            startActivity(intent);
        }

//        PackageManager pm = getPackageManager();
//        if (i == 0) {
//            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
//                            "com.me.obo.noactivity.MainActivity2"),
//                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                    PackageManager.DONT_KILL_APP);
//        }


        i++;

//        ActivityManager am = (ActivityManager)getSystemService(Activity.ACTIVITY_SERVICE);
//        PackageManager pm = getPackageManager();
//        if (("com.me.obo.noactivity.MainActivity").equals(getComponentName().getClassName())) {
//
//            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
//                            "com.me.obo.noactivity.MainActivity2"),
//                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                    PackageManager.DONT_KILL_APP);
//
//            pm.setComponentEnabledSetting(getComponentName(),
//                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                    PackageManager.DONT_KILL_APP);
//
////            intent = new Intent(this,com.me.obo.noactivity.MainActivity.class);
//
//        } else {
//
//            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
//                            "com.me.obo.noactivity.MainActivity"),
//                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                    PackageManager.DONT_KILL_APP);
//
//            pm.setComponentEnabledSetting(getComponentName(),
//                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                    PackageManager.DONT_KILL_APP);
//
////            intent = new Intent(this,com.me.obo.noactivity.MainActivity2.class);
//        }


    }


    static boolean shouldJump = true;
    private void jumpOther() {

        tv_t.setText(""+getComponentName().toString());

        ActivityManager am = (ActivityManager)getSystemService(Activity.ACTIVITY_SERVICE);
        PackageManager pm = getPackageManager();
        Intent intent;


        if (("com.me.obo.noactivity.MainActivity").equals(getComponentName().getClassName())) {

            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
                            "com.me.obo.noactivity.MainActivity2"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            pm.setComponentEnabledSetting(getComponentName(),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);

            intent = new Intent(this,MainActivity.class);

        } else {

            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
                            "com.me.obo.noactivity.MainActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            pm.setComponentEnabledSetting(getComponentName(),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);

            intent = new Intent(this,MainActivity.class);
            intent.setAction("android.intent.MainActivity2");
        }

        if (!shouldJump) {
            shouldJump = true;
            return;
        }
        shouldJump = false;
        final Intent intent1 = intent;
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(intent1);
            }
        }.start();

    }


    private void hidBack() {
//        switchCurrent();
        switch2();
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();


                }

//                switchCurrent();
                switch1();
            }
        }.start();
    }


    private void switch1() {
        PackageManager pm = getPackageManager();
        pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
                            "com.me.obo.noactivity.MainActivity2"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

        pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
                            "com.me.obo.noactivity.MainActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);

    }



    private void switch2() {
        PackageManager pm = getPackageManager();


            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
                            "com.me.obo.noactivity.MainActivity"),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            pm.setComponentEnabledSetting(new ComponentName(getBaseContext(),
                            "com.me.obo.noactivity.MainActivity2"),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);
    }

}
