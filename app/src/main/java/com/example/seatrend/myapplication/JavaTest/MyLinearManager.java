package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2018/6/5.
 */

public class MyLinearManager extends RecyclerView.LayoutManager {


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    private void init(){

    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
       // super.onLayoutChildren(recycler, state);
        if(getItemCount()<=0){return;}
        if(state.isPreLayout()){return;}

        detachAndScrapAttachedViews(recycler);
        int offsetY=0;
        totalHeight=0;
        for (int i = 0; i < getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            //测量view
            measureChildWithMargins(view,0,0);
            //获取测量后的宽高
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(view);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(view);
            //将view 布局
            layoutDecorated(view,0,offsetY,decoratedMeasuredWidth,decoratedMeasuredHeight+offsetY);
            offsetY+=decoratedMeasuredHeight;
            totalHeight+=decoratedMeasuredHeight;

            //如果所有子View的高度总和 没有填满recyclerview，则用recyclerview 的高度
            totalHeight=Math.max(totalHeight,getVerticalSpace());

        }

    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public boolean canScrollHorizontally() {
        return false;
    }

    private int verticalScrollOffSet=0;
    private int totalHeight=0;

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        //实际要滑动的距离
        int travel=dy;
        //滑动到最顶部
         if(verticalScrollOffSet + dy <0){
             travel -=verticalScrollOffSet;
         }else if(verticalScrollOffSet + dy >totalHeight-getVerticalSpace()){
                 travel=totalHeight-getVerticalSpace()-verticalScrollOffSet;
             }

             verticalScrollOffSet+=travel;
         offsetChildrenVertical(-travel);
        Log.i("travel"," ------- "+travel+"    dy == "+dy);


        return travel;
    }



    private int getVerticalSpace(){
        //除去 padding 的高度
        return getHeight()-getPaddingBottom()-getPaddingTop();
    }
}
