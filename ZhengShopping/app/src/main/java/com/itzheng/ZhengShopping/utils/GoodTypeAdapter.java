package com.itzheng.ZhengShopping.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import com.itzheng.ZhengShopping.entity.GoodType;

import java.util.ArrayList;

import ZhengShopping.R;

public class GoodTypeAdapter extends BaseAdapter {

    ArrayList<GoodType> sData = new ArrayList<GoodType>();
    private Context mContext;

    public GoodTypeAdapter(ArrayList<GoodType> sData, Context mContext) {
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

        convertView = LayoutInflater.from(mContext).inflate(R.layout.goodtypelist,null);

        TextView typename = (TextView)convertView.findViewById(R.id.typename);

        TextView goodtypecode = (TextView) convertView.findViewById(R.id.goodtypecode);

        System.out.println(sData.size() +"------++++++_-----------");
        typename.setText(sData.get(position).getTypename());
        goodtypecode.setText(sData.get(position).getGoodtypecode());

        return convertView;
    }
}
