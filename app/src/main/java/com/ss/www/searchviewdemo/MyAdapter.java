package com.ss.www.searchviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 小松松 on 2018/10/5.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> mList;

    public MyAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.TV.setText(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView TV;
        public MyViewHolder (View itemView){
            super(itemView);
            TV = itemView.findViewById(R.id.item);
        }
    }
    public void setFilter(List<String> list){
        mList = list;
        notifyDataSetChanged();
    }
}
