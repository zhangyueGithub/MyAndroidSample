package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seatrend on 2018/5/8.
 */

public class Utils {

    public static Map<String,String> logString(Context context){
        String className = context.getClass().getName(); //当前类名
        Log.i("logString","----"+className);
        Map<String,String> map=new HashMap<>();

        return map;
    }
    /**
     * 当前WIFI名
     *
     * @param context
     * @return
     */
    public static String getCurrentWifiName(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            return null;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        return wifiManager.getConnectionInfo().getSSID().replace("\"", "");
    }


}
