package com.example.seatrend.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.seatrend.myapplication.R;

/**
 * Created by seatrend on 2019/6/18.
 */

public class FocusListAdapter extends RecyclerView.Adapter<FocusListAdapter.MyViewHolder> {


    private Context mContext;

    public FocusListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_focus_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.initItemView();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.iv_img);
        }

        public void initItemView(){

        }
    }
}
