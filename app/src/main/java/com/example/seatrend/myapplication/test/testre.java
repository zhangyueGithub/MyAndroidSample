package com.example.seatrend.myapplication.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by seatrend on 2018/4/4.
 */

public class testre extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Toast.makeText(context," user present 用户手机解锁",Toast.LENGTH_SHORT).show();

        }
    }
}
