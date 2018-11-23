package com.example.seatrend.myapplication.activity;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seatrend.myapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketDemoActivity extends AppCompatActivity {
    private Button btnSend;

    private Socket mSocket;
    private BufferedReader mBufferedReader;
    private BufferedWriter mBufferedWriter;
    private static final int PORT=2306;
    private static final String IP="10.0.2.2"; //跑在电脑上的 用 10.0.2.2 访问 本机电脑 IP
    private static  String TAG="SocketDemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_demo);
        btnSend=findViewById(R.id.btn_send);
        init();
        bindEvent();
    }

    private void bindEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendMsg("sjdsllskskk");
                    }
                }).start();

            }
        });
    }

    private void init() {
        connectServer();
    }

    private void connectServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mSocket = new Socket(IP, PORT);
                    mBufferedWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "utf-8"));
                    mBufferedReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "utf-8"));

                    Log.i(TAG, "连接服务端成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i(TAG, "连接服务端失败");
                    return;
                }

                try {
                    String line;
                    while ((line = mBufferedReader.readLine()) != null) {
                        Log.i(TAG, "收到服务端消息: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i(TAG, "服务端：已停止服务");
                }
            }
        }).start();
    }


    private void sendMsg(String msg) {
        // 如果mSocket为null有可能两种情况：
        // 1.还在尝试连接服务端
        // 2.连接失败
        if (mSocket == null){
            Looper.prepare();
            Toast.makeText(this,"连接未完成或连接失败，无法发送消息！",Toast.LENGTH_SHORT).show();
            Looper.loop();
            return;
        }
        try {
            //服务端是按行读取消息，所以每条消息最后必须加换行符 \n
            mBufferedWriter.write(msg + "\n");
            mBufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            Looper.prepare();
            Toast.makeText(this,"发送失败：服务端已关闭服务！",Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if(mSocket != null){
                mSocket.shutdownInput();
                mSocket.shutdownOutput();
                mSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
