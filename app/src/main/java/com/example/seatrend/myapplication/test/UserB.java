package com.example.seatrend.myapplication.test;

import android.content.Context;
import android.util.Log;

/**
 * Created by seatrend on 2018/3/27.
 */

public  class UserB {
    private static Context mContext;
    public UserB() {
        Log.i("testuser","UserB");
    }


    public void te() {
        Log.i("testuser","UserB abstract mether");
    }

    public static void setContext(Context context){
        mContext=context;
    }


}
