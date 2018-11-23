package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.kotlin.RecyclerAdapter;
import com.example.seatrend.myapplication.kotlin.TestInterface;
import com.example.seatrend.myapplication.kotlin.module.TestModuleInterface;
import com.example.seatrend.myapplication.kotlin.presenter.TestPresenter;
import java.lang.ref.SoftReference;
/**
 * Created by seatrend on 2018/4/3.
 */

public class Test2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContex;

    String [] array=new String[10];
    int [] array2={1,2,2,3,4,4};


    public Test2(Context mContex) {
        this.mContex = mContex;

        getdata();
    }

    public void getdata() {


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater.from(mContex).inflate(R.layout.activity_main,parent,false);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
