package com.example.seatrend.myapplication.kotlin

import android.app.Activity
import java.util.ArrayList

/**
 * Created by seatrend on 2018/4/3.
 */

class test4(id: Int) {
    private var id: Int = 0
    private var age: Int = 0
    private var name: String =""

    private val data = ArrayList<String>()
    private val data1 = ArrayList<Activity>()

     constructor(id: Int, name: String) : this(id) {
        this.id = id
        this.name = name
    }

    constructor(id: Int, age: Int) :this(id){

        this.id = id
        this.age = age
    }

    constructor(id: Int, age: Int, name: String):this(id) {
        this.id = id
        this.age = age
        this.name = name
    }


    fun getMessage() {
        for (i in 0..9) {
            data.add("data" + i)

        }
    }
}
