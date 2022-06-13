package com.itzheng.ZhengShopping.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itzheng.ZhengShopping.entity.Shop;

import java.util.List;

import ZhengShopping.R;

public class ListUAdapter  extends RecyclerView.Adapter<ListUAdapter.ViewHolder> {


    private Context mContext;
    private List<Shop> list;

    public ListUAdapter(Context mContext , List<Shop> list) {
        this.mContext = mContext;
        this.list =list ;
    }

    @NonNull
    @Override
    public ListUAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weitao_item,
                parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.img_good.setImageResource(list.get(position).getImg());
        holder.good_name.setText(list.get(position).getName());


    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_good; // 商店图片
        private TextView good_name ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_good= (ImageView)itemView.findViewById(R.id.img_weitao);
            good_name = (TextView)itemView.findViewById(R.id.tv_weitao) ;
        }
    }
}

