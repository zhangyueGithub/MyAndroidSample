package com.example.seatrend.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.test.FolatService;
import com.example.seatrend.myapplication.test.UserA;
import com.example.seatrend.myapplication.test.UserB;

public class FolatTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folat_test);
       //UserA.getInstance().addActivity(this);
    }





    @SuppressLint("NewApi")
    public void startFloatingImageDisplayService(View view) {
        if (FolatService.isStarted) {
            return;
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 1);
            } else {
                startService(new Intent(this, FolatService.class));
            }
        }else {
            startService(new Intent(this, FolatService.class));
        }



    }

    @SuppressLint("NewApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                startService(new Intent(this, FolatService.class));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"FolatTestActivity is onDestroy",Toast.LENGTH_SHORT).show();
    }
}
