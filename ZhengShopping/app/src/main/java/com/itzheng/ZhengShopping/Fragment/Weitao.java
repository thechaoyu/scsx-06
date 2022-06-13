package com.itzheng.ZhengShopping.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itzheng.ZhengShopping.Adapter.ListAdapter;
import com.itzheng.ZhengShopping.Adapter.ListUAdapter;
import com.itzheng.ZhengShopping.bean.Merchant;
import com.itzheng.ZhengShopping.entity.Shop;
import com.itzheng.ZhengShopping.WeitaoActivity;
import java.util.ArrayList;
import java.util.List;

import ZhengShopping.R;

public class Weitao extends Fragment {

    private ListView listView ;
    private Toolbar toolbar ;
    private RecyclerView recyclerView  ;
    private List<Merchant> merchant;
    private List<Shop> listDatas ;

    private int[]antaimage=new int[]{R.drawable.anta1,R.drawable.anta2,R.drawable.anta3,R.drawable.anta4,
            R.drawable.anta5,R.drawable.anta6, R.drawable.t7,R.drawable.qq7,
            R.drawable.t9};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weitao_circle,container,false);

        init();
        listView=(ListView)view.findViewById(R.id.friend_list);
        listView.setAdapter(new ListAdapter(getActivity(),merchant,antaimage));


        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_weitao);
        //在此处修改布局排列方向
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // 设置水平
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        ListUAdapter listAdapter = new ListUAdapter(getActivity(),listDatas);
        recyclerView.setAdapter(listAdapter);

        return view ;


    }
    public void init(){
        merchant = new ArrayList<Merchant>();
        merchant.add(new Merchant("安踏官方网店","优质品牌","06-18",R.drawable.anta)) ;
        merchant.add(new Merchant("New Balance旗舰店","优质品牌","06-18",R.drawable.xinbailun)) ;

        listDatas = new ArrayList<>() ;
        listDatas.add(new Shop(R.drawable.dangdang,"当当旗舰店"));
        listDatas.add(new Shop(R.drawable.adlogo,"阿迪达斯旗舰店"));
        listDatas.add(new Shop(R.drawable.naike,"耐克旗舰店"));
        listDatas.add(new Shop(R.drawable.meitesi,"美特斯邦威官方"));
        listDatas.add(new Shop(R.drawable.animal_5,"振兴图书专卖"));

        listDatas.add(new Shop(R.drawable.hongdou,"红豆家具专卖"));

    }
}
