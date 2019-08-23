package com.example.seatrend.myapplication.activity;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.billy.android.swipe.SmartSwipe;
import com.billy.android.swipe.SmartSwipeBack;
import com.billy.android.swipe.SmartSwipeRefresh;
import com.billy.android.swipe.consumer.SpaceConsumer;
import com.billy.android.swipe.consumer.StretchConsumer;
import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.adapter.SmartSwipeAdapter;

public class SmartSwipeDemoActivity extends AppCompatActivity {


    /**
     * 详细用法
     * https://qibilly.com/SmartSwipe-tutorial/
     */
    private RecyclerView  mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_swipe_demo);
        initView();


    }

    private void initView() {
        mRecyclerView=findViewById(R.id.m_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SmartSwipeAdapter(this));

        SmartSwipe.wrap(mRecyclerView)
                .addConsumer(new SpaceConsumer())
                .enableHorizontal();

        /*SmartSwipe.wrap(mRecyclerView)
                .addConsumer(new StretchConsumer())
                .enableVertical()                     //仿MIUI拉伸效果的方向为：上下2个方向
                .addConsumer(new SpaceConsumer())
                .enableHorizontal() ;                //仿iOS弹性留白效果的方向为：左右2个方向;*/

       // SmartSwipeRefresh.drawerMode(mRecyclerView, false).setDataLoader(loader);
       // SmartSwipeRefresh.behindMode(mRecyclerView, false).setDataLoader(loader);
        SmartSwipeRefresh.scaleMode(mRecyclerView, false).setDataLoader(loader);
        //SmartSwipeRefresh.translateMode(mRecyclerView, false).setDataLoader(loader);

        /*
        //可以自定义  RefreshHeader  RefreshFooter
        SmartSwipeRefresh.setDefaultRefreshViewCreator(new SmartSwipeRefresh.SmartSwipeRefreshViewCreator() {
            @Override
            public SmartSwipeRefresh.SmartSwipeRefreshHeader createRefreshHeader(Context context) {
                return null;
            }

            @Override
            public SmartSwipeRefresh.SmartSwipeRefreshFooter createRefreshFooter(Context context) {
                return null;
            }
        });*/
    }


    private SmartSwipeRefresh.SmartSwipeRefreshDataLoader loader=new SmartSwipeRefresh.SmartSwipeRefreshDataLoader() {
        @Override
        public void onRefresh(SmartSwipeRefresh ssr) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ssr.finished(true);
                }
            }, 2000);

        }

        @Override
        public void onLoadMore(SmartSwipeRefresh ssr) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ssr.finished(true);
                }
            }, 2000);
        }
    };

    public void Back(View view) {

        finish();
    }
}
