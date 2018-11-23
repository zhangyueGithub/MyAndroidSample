package com.example.seatrend.myapplication.JavaTest;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by seatrend on 2018/7/17.
 */

public class AndroidObject extends Object {



    @JavascriptInterface
    public void setValue(String name){
        Log.i("TAG",name);

    }

}
