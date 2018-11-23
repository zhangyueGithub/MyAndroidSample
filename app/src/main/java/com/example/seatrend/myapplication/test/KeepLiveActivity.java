package com.example.seatrend.myapplication.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.seatrend.myapplication.MySercive;
import com.example.seatrend.myapplication.R;

public class KeepLiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_live);

        init();
    }

    private void init() {

        //startService(new Intent(this,MySercive.class));
        bindService(new Intent(this, MySercive.class), mServiceConnection, Context.BIND_AUTO_CREATE);

    }

   private ServiceConnection mServiceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("spendTime","  Service Connected -- ");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("spendTime","  Service Disconnected -- ");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }


}
