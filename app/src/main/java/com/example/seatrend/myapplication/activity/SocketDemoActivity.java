package com.example.seatrend.myapplication.activity;

import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seatrend.myapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class SocketDemoActivity extends AppCompatActivity {
    private Button btnSend;

    private Socket mSocket;
   // private BufferedReader mBufferedReader;
  //  private BufferedWriter mBufferedWriter;
//    private static final int PORT=8306;
//    private static final String IP="192.168.0.50"; //跑在电脑上的 用 10.0.2.2 访问 本机电脑 IP
    private static final int PORT=60000;
    private static final String IP="192.168.0.50";
    private static  String TAG="sdkjdla";
    private EditText etMsg;
    private InputStream inputStream;
    private PrintWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_demo);
        btnSend=findViewById(R.id.btn_send);
        etMsg=findViewById(R.id.et_msg);

        init();
        bindEvent();
    }

    private void bindEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String msg = etMsg.getText().toString();
                if (!TextUtils.isEmpty(msg)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(msg);
                        }
                    }).start();
                }else {
                    Toast.makeText(SocketDemoActivity.this,"请输入发送信息",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void init() {
        connectServer();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                readServerMessage();
            }
        }).start();*/

    }
    private OkHttpClient mOkHttpClient;

    private void webSocketConnect() {
        mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.0.53:8085/jyptdbctl/websocket/tvVideo")
                .build();
        ClientWebSocketListener listener=new ClientWebSocketListener();
        mOkHttpClient.newWebSocket(request,listener);
        mOkHttpClient.dispatcher().executorService().shutdown();
    }
    private void connectServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    mSocket = new Socket(IP, PORT);
                   // mBufferedWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "utf-8"));
                   // mBufferedReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "utf-8"));
                    inputStream = mSocket.getInputStream();
                    writer = new PrintWriter(new OutputStreamWriter(mSocket.getOutputStream(), "utf-8"));


                    Log.i(TAG, "连接服务端成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i(TAG, "连接服务端失败"+e.getMessage());
                }

                try {
                    /*String line;
                    while ((line = mBufferedReader.readLine()) != null) {
                        Log.i(TAG, "收到服务端消息: " + line);
                    }*/
                    int i=0;
                    byte[] bytes = new byte[1024];
                    while ((i = inputStream.read(bytes))!=-1){
                        String str = new String(bytes,0,i,"utf-8");
                        Log.i(TAG, "收到服务端消息: " +i+"    "+str);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "服务端：已停止服务");
                }
                Log.i(TAG, "PASS 1");
               // readServerMessage();
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
        Log.i(TAG, "sendMsg: " +msg);
        try {
            //服务端是按行读取消息，所以每条消息最后必须加换行符 \n
            //mBufferedWriter.write(msg + "\n");
            //mBufferedWriter.flush();
            writer.write(msg);
            writer.flush();
        } catch (Exception e) {
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

    /**
     * 读取服务器发来的信息，并通过Handler发给UI线程
     */
    public void readServerMessage() {
       /* try {
            while (true) {//死循环守护，监控服务器发来的消息
                if (!mSocket.isClosed()) {//如果服务器没有关闭
                    if (mSocket.isConnected()) {//连接正常
                        if (!mSocket.isInputShutdown()) {//如果输入流没有断开
                            String line;
                            StringBuffer buffer=new StringBuffer();
                            while ((line = mBufferedReader.readLine()) != null) {
                                buffer.append(line);
                            }
                            Log.i(TAG, "收到服务端消息: " + buffer.toString());
                        }
                    }
                }
                Log.i("sdawwww", "sdaaaaaaaaaaas " );
            }
        } catch (Exception e) {
            Log.i(TAG, "Exception: " +e.getMessage());

        }*/
    }

    private WebSocket mWebSocket;

    private final class ClientWebSocketListener extends WebSocketListener {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            mWebSocket=webSocket;
            mWebSocket.send("您好，我是客户端");
            Log.i(TAG,"WebSocket 连接成功--- "+response.body().toString());
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            Message message=Message.obtain();
            message.obj=text;
            Log.i(TAG,"服务端消息--- "+text);
            //mWebSocketHandler.sendMessage(message);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            Message message=Message.obtain();
            message.obj=bytes.utf8();
            Log.i(TAG,"服务端消息--- "+bytes.utf8());
           // mWebSocketHandler.sendMessage(message);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            if(null!=mWebSocket){
                mWebSocket.close(1000,"再见");
                mWebSocket=null;
            }
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            Log.i(TAG,"WebSocket 已关闭--- "+reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t,  Response response) {
            Log.i(TAG,"WebSocket 连接失败--- "+t.getMessage());
        }
    }
}
