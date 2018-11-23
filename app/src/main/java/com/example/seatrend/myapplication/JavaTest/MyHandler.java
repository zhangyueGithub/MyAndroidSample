package com.example.seatrend.myapplication.JavaTest;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by seatrend on 2018/8/3.
 */

public class MyHandler extends Handler {


    private WeakReference<Context> weakReference;

    public MyHandler(Context context){
        weakReference=new WeakReference<>(context);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Context context = weakReference.get();
        if(context!=null){
            // TODO other
        }
    }

    public void cleanHandler(){
        removeCallbacksAndMessages(null);
    }
}
