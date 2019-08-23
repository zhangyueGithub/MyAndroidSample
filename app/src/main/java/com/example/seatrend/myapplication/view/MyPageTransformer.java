package com.example.seatrend.myapplication.view;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2019/8/22.
 */

public class MyPageTransformer implements ViewPager.PageTransformer {

    private int mOffset=20;
    private int spacingTop=40;
    private int spacing=10;

    @Override
    public void transformPage(View page, float position) {
        Log.i("sssaa","--  "+position);
        //page.setAlpha(0.5f);
        if (position<0f){
            page.setTranslationX(0);
        }else {
            page.setTranslationX((-page.getWidth() * position));
            float my = spacingTop - (spacing * position);
            if (my>30){
                my=30;
            }
            Log.i("mmmy","my--  "+my);
            page.setTranslationY(my);
            //缩放比例
            float scale = (page.getWidth() - mOffset * position) / (float) (page.getWidth());

            //设置水平方向缩放
            page.setScaleX(scale);

            //设置竖直方向缩放
         //   page.setScaleY(scale);

            //设置竖直方向偏移量
            float y = mOffset * position;
            Log.i("affss","--  "+y);
            //page.setTop((int) y);
           //page.setTranslationY(y);


        }

    }


}
