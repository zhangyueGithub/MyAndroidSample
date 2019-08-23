package com.example.seatrend.myapplication.view;

import android.content.Context;
import android.view.View;

import com.billy.android.swipe.SmartSwipeRefresh;

/**
 * Created by seatrend on 2019/8/1.
 */

public class SmartSwipeHeaderView implements SmartSwipeRefresh.SmartSwipeRefreshHeader {

    private Context context;


    @Override
    public View getView() {
        return null;
    }

    @Override
    public void onInit(boolean horizontal) {

    }

    @Override
    public void onStartDragging() {

    }

    @Override
    public void onProgress(boolean dragging, float progress) {

    }

    @Override
    public long onFinish(boolean success) {
        return 0;
    }

    @Override
    public void onReset() {

    }

    @Override
    public void onDataLoading() {

    }
}
