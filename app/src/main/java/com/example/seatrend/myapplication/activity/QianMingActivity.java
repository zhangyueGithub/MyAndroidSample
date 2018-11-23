package com.example.seatrend.myapplication.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.seatrend.myapplication.JavaTest.AutographView;
import com.example.seatrend.myapplication.R;

import java.io.IOException;

public class QianMingActivity extends AppCompatActivity {

    private AutographView mLinePathView;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qian_ming);
        init();

    }

    private void init() {
        path= Environment.getExternalStorageDirectory().toString()+"/qingming";
        mLinePathView=findViewById(R.id.lpv);
        mLinePathView.setBackColor(getResources().getColor(R.color.white));
    }

    public void chongxing(View view) {
        mLinePathView.clear();
    }

    public void saveOnClick(View view) {
        mLinePathView.getBitMap();
        try {
            mLinePathView.save(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
