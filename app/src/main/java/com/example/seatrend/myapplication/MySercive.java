package com.example.seatrend.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by seatrend on 2018/4/13.
 */

public class MySercive extends Service {

    private int tag=0;
    private MyBinder myBinder;
    private TimerTask task;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("spendTime"," - Service onCreate-- ");
        myBinder=new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("spendTime"," - Service onStartCommand-- ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        spendTime();
        return myBinder;
    }


    private void spendTime(){

        task = new TimerTask() {
            @Override
            public void run() {
                tag++;
                Log.i("spendTime"," --- "+tag);

            }
        };

        Timer timer=new Timer();
        timer.schedule(task,0,3000);




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        task.cancel();
        Log.i("spendTime"," service---onDestroy ");

    }

    public class MyBinder extends Binder{
        public MySercive getService() {
            return MySercive.this;
        }
    }
}
