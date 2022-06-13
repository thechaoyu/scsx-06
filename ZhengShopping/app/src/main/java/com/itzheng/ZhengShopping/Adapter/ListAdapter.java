package com.itzheng.ZhengShopping.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.itzheng.ZhengShopping.ImageActivity;
import com.itzheng.ZhengShopping.bean.Merchant;
import java.util.List;

import ZhengShopping.R;

public class ListAdapter extends BaseAdapter {


    private Context mContext;
    private int [] image ;
    private List<Merchant> list;


    public ListAdapter(Context mContext ,List<Merchant> list,int [] image) {
        this.mContext = mContext;
        this.image = image ;
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
        private TextView name; // 店名
        private TextView content; // 时间
        private ImageView imageView; // 商品图片
        private GridView gridView; // 商品展示图片
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHoler=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.setting_circle_list,null);
            viewHoler.imageView=convertView.findViewById(R.id.image);
            viewHoler.name=convertView.findViewById(R.id.name);
            viewHoler.content=convertView.findViewById(R.id.content);
            viewHoler.gridView=convertView.findViewById(R.id.gridview);
            convertView.setTag(viewHoler);
        }else {
            viewHoler=(ViewHolder)convertView.getTag();
        }


        viewHoler.imageView.setImageResource(list.get(position).getImgid());
        viewHoler.name.setText(list.get(position).getShop_name());
        viewHoler.content.setText(list.get(position).getType());
        viewHoler.gridView.setAdapter(new GridViewAdapter(mContext,image));
        viewHoler.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(mContext, ImageActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("image",image);

                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
}