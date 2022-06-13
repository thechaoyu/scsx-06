package com.itzheng.ZhengShopping.utils;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import com.itzheng.ZhengShopping.entity.Goods;

import java.util.ArrayList;

import ZhengShopping.R;

public class OrderDetailListAdapter extends BaseAdapter {


    double total = 0;

    ArrayList<Goods> sData = new ArrayList<>();

    private AppCompatActivity appCompatActivity;

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    private Context mContext;

    public OrderDetailListAdapter(ArrayList<Goods> sData, Context mContext) {
        this.sData = sData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return sData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //goodnumber_order

        convertView = LayoutInflater.from(mContext).inflate(R.layout.orderlist_layout,null);

        MyImageView image_order = (MyImageView)convertView.findViewById(R.id.image_order);

        TextView goodname_order = (TextView) convertView.findViewById(R.id.goodname_order);

        TextView goodprice_order = (TextView) convertView.findViewById(R.id.goodprice_order);

        EditText goodnumber_order = (EditText) convertView.findViewById(R.id.goodnumber_order);

        TextView goodcode_order = (TextView) convertView.findViewById(R.id.goodcode_order);

        image_order.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+sData.get(position).getGoodimagecode());

        goodname_order.setText(sData.get(position).getGoodname());

        goodprice_order.setText(sData.get(position).getGoodprice());

        goodnumber_order.setText(sData.get(position).getGoodstate());

        goodcode_order.setText(sData.get(position).getGoodcode());


        TextView cal = appCompatActivity.findViewById(R.id.calorder);

        total += Double.parseDouble(sData.get(position).getGoodprice())*Double.parseDouble(sData.get(position).getGoodstate()) ;
        //* Double.parseDouble(sData.get(position).getGoodstate()) +""
        cal.setText("总价：￥"+total);

        return convertView;
    }
}
