package com.example.seatrend.myapplication.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.seatrend.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpTestActivity extends AppCompatActivity {
    StringBuilder teststring=new StringBuilder();

    private TextView tvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_http_test);
        tvTest=findViewById(R.id.tv_test);
        Map<String,String> map=new HashMap<>();

        map.put("xh","5106LR0000005463");
        map.put("mac", "B2:15:3E:97:54:96");
        map.put("idNumber","511302198111191433");
        //map.put("idPictureStr", BitmapUtils.bitmapToBase64(BitmapUtils.compressImage(autographView.getAutographBitmap())));
        map.put("idPictureStr","/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/wAARCAGIAuMDASIAAhEBAxEB/8QAFQABAQAAAAAAAAAAAAAAAAAAAAv/xAAUEAEAAAAAAAAAAAAAAAAAAAAA/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJ/4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        map.put("plateNumber","川AJL122");
        map.put("plateType","a2");
        map.put("xm","唐光兵");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            teststring.append(entry.getKey().trim()+"="+entry.getValue().trim()+"&");
        }
    }
    String finalUrl="http://11.1.1.73:18090/electricPaymentInterface/violation/updateJFStateByXh";
    public void onTest(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL myurl = null;
                try {
                    myurl = new URL(finalUrl);
                    Log.i("HttpService"," myurl == "+finalUrl);
                    //2;url.openconnection
                    HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setConnectTimeout(60 * 1000);
                    conn.setReadTimeout(60 * 1000);
                    String substring = teststring.toString().substring(0, teststring.length() - 1);
                    conn.getOutputStream().write(substring.getBytes());

                    InputStream in = conn.getInputStream();
                    //下面对获取到的输入流进行读取
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    Log.i("HttpService"," -- "+response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("HttpService"," -Exception- "+e.getMessage());
                }

            }
        }).start();
    }

    public void onScanTest(View v){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setComponent(new ComponentName("com.seatrend.cd.scanmanager","com.seatrend.cd.scanmanager.MainActivity"));
        intent.putExtra("cylsh","");
        intent.putExtra("clsbdh","");
        intent.putExtra("clxh","");
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==10 && resultCode == RESULT_OK && data !=null){
            String dataMsg = data.getStringExtra("data");

            tvTest.setText(dataMsg);
        }
    }
}
