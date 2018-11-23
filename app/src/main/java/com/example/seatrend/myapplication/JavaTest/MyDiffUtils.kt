package com.example.seatrend.myapplication.JavaTest

import android.support.v7.util.DiffUtil

import java.util.ArrayList

/**
 * Created by seatrend on 2018/4/8.
 */

class MyDiffUtils(internal var oldData: List<String>?, internal var newData: List<String>?) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return if (oldData == null) 0 else oldData!!.size
    }

    override fun getNewListSize(): Int {
        return if (newData == null) 0 else newData!!.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData!![oldItemPosition] == newData!![newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData!![oldItemPosition] == newData!![newItemPosition]
    }
}
