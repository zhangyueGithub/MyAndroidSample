package com.example.seatrend.myapplication.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.seatrend.myapplication.R

/**
 * Created by seatrend on 2018/4/3.
 */
class RecyclerAdapter(private var mContext:Context,private var data:List<String>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
    override fun getItemCount(): Int {
        return 10
    }

    @Suppress("UNREACHABLE_CODE")
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(mContext).inflate(R.layout.testitem, parent, false)

        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        holder!!.initItemView(data.get(position))

    }


    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var textView:TextView?
       init {
            textView = itemView.findViewById<TextView>(R.id.text)
       }
        fun initItemView(st: String){
            textView!!.text=st
        }

    }
}