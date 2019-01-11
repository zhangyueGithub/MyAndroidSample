package com.example.seatrend.myapplication.activity;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seatrend.myapplication.MainActivity;
import com.example.seatrend.myapplication.R;

public class BlueToothActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BtnSearch;
    private BluetoothAdapter mBluetoothAdapter;
    private static final int REQUEST_ENABLE_BT=8;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth);
        BtnSearch=findViewById(R.id.btn_search);
        BtnSearch.setOnClickListener(this);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void init() {
      BluetoothManager bluetoothManager= (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
     mBluetoothAdapter=bluetoothManager.getAdapter();
     if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
        mBluetoothAdapter.startLeScan(mLeScanCallback);
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback=new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            Log.i("mLeScanCallback"," Bluetooth name = "+device.getName());

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.layout.activity_blue_tooth:
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onPause() {
        super.onPause();
        mBluetoothAdapter.stopLeScan(mLeScanCallback);
    }

    private void tees(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
