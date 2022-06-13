package com.itzheng.ZhengShopping.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import ZhengShopping.R;

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private int[]images;

    public GridViewAdapter(Context mContext, int[] images) {
        this.mContext = mContext;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.gridview_list,null);
            imageView=convertView.findViewById(R.id.grid_image);
            convertView.setTag(imageView);
        }else{
            imageView=(ImageView)convertView.getTag();
        }
        imageView.setImageResource(images[position]);
        return convertView;
    }
}
