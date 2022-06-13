package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.Adapter.ListAdapter;
import com.itzheng.ZhengShopping.bean.Merchant;
import com.itzheng.ZhengShopping.entity.Shop;

import java.util.ArrayList;
import java.util.List;

import ZhengShopping.R;

public class WeitaoActivity extends AppCompatActivity {
    ListView listView;
    List<Merchant> merchant=new ArrayList<>();
    private int[]antaimage=new int[]{R.drawable.anta1,R.drawable.anta2,R.drawable.anta3,R.drawable.anta4,
            R.drawable.anta5,R.drawable.anta6, R.drawable.t7,R.drawable.qq7,
            R.drawable.t9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weitao);
        listView=(ListView)findViewById(R.id.friend_list);
        merchant.add(new Merchant("安踏官方网店","优质品牌","06-18",R.drawable.anta)) ;
        merchant.add(new Merchant("New Balance旗舰店","优质品牌","06-18",R.drawable.xinbailun)) ;
        ListAdapter ladapter=new ListAdapter(WeitaoActivity.this,merchant,antaimage);
        listView.setAdapter(ladapter);
    }

    public void shouye(View view){
        finish();
        Intent it=new Intent();
        it.setClass(WeitaoActivity.this,AdminActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(), AdminActivity.class));
    }

    public void xiaoxi(View view){
        finish();
        Intent it=new Intent();
        it.setClass(WeitaoActivity.this,XiaoxiActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(), XiaoxiActivity.class));
    }

    public void gouwuche(View view){
        finish();
        Intent it=new Intent();
        it.setClass(WeitaoActivity.this,CarActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        startActivity(new Intent(getApplicationContext(),CarActivity.class));
    }

    public void wode(View view){
        finish();
        Intent it=new Intent();
        it.setClass(WeitaoActivity.this,MyMainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(),MyMainActivity.class));

    }
}
