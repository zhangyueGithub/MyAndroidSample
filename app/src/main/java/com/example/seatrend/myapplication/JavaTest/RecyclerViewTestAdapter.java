package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seatrend.myapplication.R;

import java.util.List;

/**
 * Created by seatrend on 2018/6/20.
 */

public class RecyclerViewTestAdapter extends RecyclerView.Adapter<RecyclerViewTestAdapter.MyViewHolder> {

    private List<String> data;
    private Context mContext;

    public RecyclerViewTestAdapter(List<String> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.testitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data == null ? 0: data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
