package com.itzheng.ZhengShopping.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itzheng.ZhengShopping.bean.ChatDate;

import java.util.List;

import ZhengShopping.R;

public class ChatAdapter extends BaseAdapter {
    private Context mContext;
    private List<ChatDate> list;

    public ChatAdapter(Context mContext, List<ChatDate> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static class ViewHoler{
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoler viewHoler = new ViewHoler();
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.chat_list,null);
            viewHoler.imageView = view.findViewById(R.id.iv_item);
            viewHoler.textView1 = view.findViewById(R.id.tv_name);
            viewHoler.textView2 = view.findViewById(R.id.tv_content);
            viewHoler.textView3 = view.findViewById(R.id.tv_time);
            view.setTag(viewHoler);
        }
        else {
            viewHoler = (ViewHoler) view.getTag();
        }

        viewHoler.imageView.setImageResource(list.get(i).getResourceID());
        viewHoler.textView1.setText(list.get(i).getName());
        viewHoler.textView2.setText(list.get(i).getContent());
        viewHoler.textView3.setText(list.get(i).getTime());

        return view;
    }
}
