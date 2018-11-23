package com.example.seatrend.myapplication.test;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seatrend on 2018/3/27.
 */

public  class UserA {
    private static Context mContext;
    private static UserA mUserA;
    private static List<Activity> list=new ArrayList<>();

    private UserA() {
    }

    public static void setContext(Context context){
        mContext=context;
    }
    public static UserA getInstance(){
        if(mUserA ==null){
            mUserA=new UserA();
        }
        return mUserA;
    }
    public void addActivity(Activity activity){
        list.add(activity);
    }


}
