package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.FoodBean;

import java.util.List;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class Base extends BaseAdapter {
    private Context context;
    private List<FoodBean.DataBean.CategoriesBean.ProductsBean> list;

    public Base(Context context, List<FoodBean.DataBean.CategoriesBean.ProductsBean> list) {
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
        Holder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.bujv,null);
            holder = new Holder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView3);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getName());
        holder.textView2.setText("￥"+list.get(position).getPrice());
        Glide.with(context).load(list.get(position).getApp_long_image2()).into(holder.imageView);
        return convertView;
    }

    class Holder{
        TextView textView,textView2;
        ImageView imageView;
    }
}
