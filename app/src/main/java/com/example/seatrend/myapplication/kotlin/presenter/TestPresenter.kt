package com.example.seatrend.myapplication.kotlin.presenter

import com.example.seatrend.myapplication.kotlin.module.TestModuleInterface
import com.example.seatrend.myapplication.kotlin.module.TestModule
import com.example.seatrend.myapplication.kotlin.view.TestView

/**
 * Created by seatrend on 2018/4/3.
 */
class TestPresenter : TestModuleInterface {
    var mTestModule=TestModule(this);
    var mTestView:TestView?

    constructor(mTestView: TestView?) {
        this.mTestView = mTestView
    }


    override fun success(msg:String){
        mTestView!!.success(msg)

    }

    override fun fail(msg:String) {

    }

    fun  getMessage(id:Int){
        mTestModule.getData(id)
    }
}