package com.example.seatrend.myapplication.kotlin

import android.util.Log
import java.util.ArrayList


/**
 * Created by seatrend on 2018/4/3.
 */

class test2(private val id: Int, private val name: String, private val age: Int) :TestInterface{
    override fun getMessage(id: Int) {

    }

    fun getmessage(): String {
        return "got it"
    }

    fun myListTest(id: Int,age: Int):Int{
        var data=ArrayList<String>();

        for (i in 0..data.size){

        }

        test3.getName()
        when(id){
            1-> Log.i("tag","1")
            2->Log.i("tag","2")
            in 5..9->Log.i("tag","2")

        }
        return if (id>age)id else age
    }

}
