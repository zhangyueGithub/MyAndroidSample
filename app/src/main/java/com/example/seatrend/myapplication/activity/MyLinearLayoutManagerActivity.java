package com.example.seatrend.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.seatrend.myapplication.JavaTest.MyLinearManager;
import com.example.seatrend.myapplication.JavaTest.RecyclerViewTestAdapter;
import com.example.seatrend.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyLinearLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_linear_layout_manager);
        mRecyclerView=findViewById(R.id.m_recycler_view);
        initView();
    }

    private void initView() {
        for (int i = 0; i <50; i++) {
            list.add("data  "+i);
        }

        RecyclerViewTestAdapter adapter= new RecyclerViewTestAdapter(list,this);
        MyLinearManager linearManager=new MyLinearManager();
        mRecyclerView.setLayoutManager(linearManager);
        mRecyclerView.setAdapter(adapter);
    }
}
