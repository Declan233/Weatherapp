package com.example.xiaochong.myapplication.Adpter;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiaochong.myapplication.R;
import com.example.xiaochong.myapplication.entity.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaochong on 2018/4/15.
 */

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyHolder>{

    private List<String> list = new ArrayList<>();

    private static final String TAG = "MyBaseAdapter";

    public MyBaseAdapter(List<String> list){
        this.list = list;
        Log.d(TAG, "MyBaseAdapter: "+this.list.size());
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent,false);
        MyHolder mh = new MyHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        String text = list.get(position);
        holder.mytv.setText(text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        TextView mytv;

        public MyHolder(View itemView) {
            super(itemView);
            mytv = itemView.findViewById(R.id.cvtv);
        }
    }
}
