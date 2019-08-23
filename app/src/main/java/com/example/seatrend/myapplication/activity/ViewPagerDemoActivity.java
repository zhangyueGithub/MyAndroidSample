package com.example.seatrend.myapplication.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.adapter.ViewPagerAdapter;
import com.example.seatrend.myapplication.view.MyPageTransformer;

public class ViewPagerDemoActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        init();
    }

    private void init() {
        viewPager=findViewById(R.id.view_pager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(this);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setPageTransformer(true,new MyPageTransformer());
        viewPager.setAdapter(adapter);
    }
}
