package com.example.xiaochong.myapplication.Adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.xiaochong.myapplication.R;


import java.util.List;

/**
 * Created by xiaochong on 2018/3/18.
 */
//重写父类的方法
public class ListAdapter extends BaseAdapter {
    private Context context;
    private List list;

//添加我们的构造方法
    public ListAdapter(Context context ,List list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Holder  holder;
        if(convertView==null){
            holder = new Holder();
            convertView = View.inflate(context, R.layout.item,null);
            holder.tv = (TextView) convertView.findViewById(R.id.TextName);//找到子布局中的控件
            //设置标志
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        holder.tv.setText(list.get(position).toString());//设置文本的信息值
        return convertView;
    }

    class Holder{
        TextView tv;
    }
}
