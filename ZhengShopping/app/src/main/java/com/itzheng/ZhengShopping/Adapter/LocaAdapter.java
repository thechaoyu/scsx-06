package com.itzheng.ZhengShopping.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itzheng.ZhengShopping.bean.Userinfo;

import java.util.List;

import ZhengShopping.R;


public class LocaAdapter extends BaseAdapter {


    private Context mContext;

    private List<Userinfo> list;


    public LocaAdapter(Context mContext , List<Userinfo> list) {
        this.mContext = mContext;
        this.list =list ;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{

        private TextView user_D_name; // 名字
        private TextView user_D_number; // 手机号
        private TextView location;
        private ImageView iv_user ;
        public ViewHolder(){

        }

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHoler=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.location_item,null);
            viewHoler.user_D_name=convertView.findViewById(R.id.user_D_name);
            viewHoler.user_D_number=convertView.findViewById(R.id.user_D_number);
            viewHoler.location = convertView.findViewById(R.id.location);
            viewHoler.iv_user = (ImageView)convertView.findViewById(R.id.iv_user) ;

            convertView.setTag(viewHoler);
        }else {
            viewHoler=(ViewHolder)convertView.getTag();
        }


        viewHoler.iv_user.setImageResource(list.get(position).getImg());
        viewHoler.user_D_name.setText(list.get(position).getUsername());
        viewHoler.location.setText(list.get(position).getUserlocation());
        viewHoler.user_D_number.setText(list.get(position).getUseriphone());

        return convertView;
    }

}









