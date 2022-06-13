package com.itzheng.ZhengShopping.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import com.itzheng.ZhengShopping.entity.Goods;

import java.util.ArrayList;

import ZhengShopping.R;

public class GoodListAdapter extends BaseAdapter {

    ArrayList<Goods> sData = new ArrayList<>();
    private Context mContext;

    public GoodListAdapter(ArrayList<Goods> sData, Context mContext) {
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


        convertView = LayoutInflater.from(mContext).inflate(R.layout.good_list,null);

        MyImageView myige = (MyImageView)convertView.findViewById(R.id.image);

        TextView goodname = (TextView) convertView.findViewById(R.id.goodname);
        TextView goodprice = (TextView) convertView.findViewById(R.id.goodprice);
        TextView gooddetail = (TextView) convertView.findViewById(R.id.gooddetail);
        TextView goodcode = (TextView) convertView.findViewById(R.id.goodcode);

        goodname.setText(sData.get(position).getGoodname());
        goodprice.setText("￥："+sData.get(position).getGoodprice());
        gooddetail.setText(sData.get(position).getGooddetail());
        goodcode.setText(sData.get(position).getGoodcode());
        // myImageView.setImageURL("http://10.0.2.2:8082/Zhengshop/image/upload/good/"+Goodsalist.get(0).getGoodimagecode());
        myige.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+sData.get(position).getGoodimagecode());

        return convertView;

    }
}
