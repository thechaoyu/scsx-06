package com.itzheng.ZhengShopping.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import com.itzheng.ZhengShopping.entity.Orders;

import java.util.ArrayList;

import ZhengShopping.R;

public class PaidAdapter extends BaseAdapter {

    ArrayList<Orders> sData = new ArrayList<>();

    private Context mContext;

    public PaidAdapter(ArrayList<Orders> sData, Context mContext) {
        this.sData = sData;
        this.mContext = mContext;
    }

    private AppCompatActivity appCompatActivity;

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
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

        convertView = LayoutInflater.from(mContext).inflate(R.layout.orderlistmy_layout,null);

        TextView ordercode_order = (TextView) convertView.findViewById(R.id.ordercode_order);
        TextView usercode_order = (TextView) convertView.findViewById(R.id.usercode_order);
        TextView state_order = (TextView) convertView.findViewById(R.id.state_order);
        TextView date_order = (TextView) convertView.findViewById(R.id.date_order);
        TextView price_order = (TextView) convertView.findViewById(R.id.price_order);

        ordercode_order.setText(sData.get(position).getOrdercode()  );
        usercode_order.setText(sData.get(position).getUsercode()  );
        state_order.setText(sData.get(position).getState());
        date_order.setText(sData.get(position).getDate() );
        price_order.setText("￥"+sData.get(position).getPrice()  );
        return convertView;
    }
}
