package com.example.seatrend.myapplication.test;

import android.content.Context;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2018/3/30.
 */

public abstract class TestOnClick implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Log.i("TestOnClick","OnClickListener");
        OnClickEvent(view);
    }

    public abstract void OnClickEvent(View view);

    public static void testMethord(Context context){
        String Classname = context.getClass().getName(); //url
        String Methodname = Thread.currentThread().getStackTrace()[2].getMethodName();

        Log.i("TestOnClick","Classname  == "+Classname +"  Methodname == "+Methodname);
    }
}
