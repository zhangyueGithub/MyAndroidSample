package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by seatrend on 2018/6/15.
 */

public class MyCreateView extends ViewGroup {



    public MyCreateView(Context context) {
        super(context);
        init(context);
    }

    public MyCreateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyCreateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top=0;
        int left=0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int childViewMeasuredWidth = childView.getMeasuredWidth();
            if(childViewMeasuredWidth+left>getMeasuredWidth()){
                left=0;
                top+=childView.getMeasuredHeight();
            }
            childView.layout(left,top,childViewMeasuredWidth+left,childView.getMeasuredHeight()+top);
            left+=childViewMeasuredWidth;
        }
        //layout();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void init(Context context){

    }
}
