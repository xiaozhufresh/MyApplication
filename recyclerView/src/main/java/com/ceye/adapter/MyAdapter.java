package com.ceye.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ceye.recyclerview.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int[] mDataset; // 外面传入的数据
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    private OnItemClickListener listener; // 点击Item的回调对象

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        // TODO Auto-generated method stub
        public ViewHolder(View v) {
            super(v);
        }

    }

    public MyAdapter(int[] mDataset) {
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.mImageView = (ImageView) v.findViewById(R.id.iv_image);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        holder.mImageView.setImageResource(mDataset[position]);
        if (listener!=null){
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(v,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
