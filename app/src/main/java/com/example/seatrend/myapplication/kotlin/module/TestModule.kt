package com.example.seatrend.myapplication.kotlin.module

import android.util.Log

/**
 * Created by seatrend on 2018/4/3.
 */
class TestModule {
    var mTestModuleInterface:TestModuleInterface ?

    constructor(testModuleInterface: TestModuleInterface){
        this.mTestModuleInterface=testModuleInterface;
    }


    fun getData(id:Int){

       // "this is internet get message"

        Log.i("TestModule", "id = "+id)

        mTestModuleInterface!!.success("this is internet get message")
    }
}