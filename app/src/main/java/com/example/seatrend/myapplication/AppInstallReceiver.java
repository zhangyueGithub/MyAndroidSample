package com.example.seatrend.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by seatrend on 2018/4/3.
 * 程序卸载监听广播，主程序卸载后，自动弹出卸载自己窗口
 */

public class AppInstallReceiver extends BroadcastReceiver {

    private final String HOME_PACKAGE_NAME="com.seatrend.outerdetection";//主程序的 包名
    private final static String TAG="AppInstallReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

       /* //Intent.ACTION_PACKAGE_REPLACED  替换
         Intent.ACTION_PACKAGE_ADDED  更新或与安装
       boolean isUpdate = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
        true  是更新 false 安装*/
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)) {
            String packageName = intent.getData().getSchemeSpecificPart();
            if(packageName.equals(HOME_PACKAGE_NAME)){
                String currentPackageName= context.getPackageName();
                unstallApp(context,currentPackageName);
            }
        }

        /*String packageName = intent.getData().getSchemeSpecificPart();
        switch (intent.getAction()){
            case Intent.ACTION_PACKAGE_REMOVED:
                Log.i(TAG,"收到卸载广播，包名为"+packageName);
                break;
            case Intent.ACTION_MY_PACKAGE_REPLACED:
                Log.i(TAG,"收到App更新广播，包名为"+packageName);
                break;
            case Intent.ACTION_PACKAGE_ADDED:
                Log.i(TAG,"收到App安装广播，包名为"+packageName);
                break;
        }*/



    }


    public  void unstallApp(Context context,String packageName){
        Intent uninstall_intent = new Intent();
        uninstall_intent.setAction(Intent.ACTION_DELETE);
        uninstall_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        uninstall_intent.setData(Uri.parse("package:"+packageName));
        context.startActivity(uninstall_intent);
    }
}
