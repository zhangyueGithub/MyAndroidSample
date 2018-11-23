package com.example.seatrend.myapplication.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.seatrend.myapplication.JavaTest.MyHandler;
import com.example.seatrend.myapplication.JavaTest.SignUtiles;
import com.example.seatrend.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TaskTestActivity extends AppCompatActivity {
    Spinner mSpinner;
    Toolbar tb;
    ViewStub mViewStub;
    Button btn1,btn2;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_test);
        mSpinner= findViewById(R.id.m_spinner);
        tb= findViewById(R.id.tb);
        mViewStub=findViewById(R.id.view_stub);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        linear=findViewById(R.id.linear);
        setSupportActionBar(tb);
        init();
        addOther();
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {

                final int count = mSpinner.getCount();
                if(position == count -1) {
                    final EditText editText = new EditText(TaskTestActivity.this);
                    AlertDialog alertDialog = new AlertDialog.Builder(TaskTestActivity.this)
                            .setTitle("请输入您的值")
                            .setView(editText)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {


                                    Editable text = editText.getText();
                                    if (!TextUtils.isEmpty(text)) {
                                        ArrayAdapter adapter = (ArrayAdapter) mSpinner.getAdapter();
                                        adapter.remove("手动输入");
                                        adapter.add(text);
                                        adapter.add("手动输入");
                                        dialog.dismiss();
                                        mSpinner.setSelection(position);
                                    } else {
                                        Toast.makeText(TaskTestActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    mSpinner.setSelection(0);
                                }
                            })
                            .create();
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        @Override
                        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                            if(keyCode == KeyEvent.KEYCODE_BACK){
                                return true;
                            }
                            return false;
                        }
                    });
                    alertDialog.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initbtn();
    }


    private void initbtn() {
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("OnClickBtn"," btn1 ---onTouchEvent");
                return false;
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i("OnClickBtn"," Activity ---onTouchEvent"+super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }


    private void init() {
        Log.i("getAPPSign","------"+ SignUtiles.getAPPSign(this));
        //x.509  AC4201A3BAEF8A372252F77EBCF822AA
        View stubView = mViewStub.inflate();//text
        TextView textView=stubView.findViewById(R.id.text);
        textView.setText("ViewStub");
        WifiManager wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.item_spinner_common);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i < 7; i++) {
          adapter.add("data"+i);
        }
        mSpinner.setAdapter(adapter);
        mSpinner.setSelection(0);

        Set set= new HashSet();
        Set set1= new TreeSet();
        List list=new ArrayList();
        List list1=new LinkedList();
        Map map=new HashMap();
        Map map1=new TreeMap();

    }

    private void addOther(){
        ArrayAdapter adapter = (ArrayAdapter) mSpinner.getAdapter();
        adapter.add("手动输入");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test1,menu);
        return true;
    }

    public void OnClickBtn1(View view) {
        Log.i("OnClickBtn","OnClickBtn1");

    }

    public void OnClickBtn2(View view) {
        Log.i("OnClickBtn","OnClickBtn2");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    private MyHandler myHandler=new MyHandler(this){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

};
