package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.Adapter.LocaAdapter;
import com.itzheng.ZhengShopping.bean.Userinfo;
import com.itzheng.ZhengShopping.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import ZhengShopping.R;


public class DizhiActivity extends AppCompatActivity {
    private Userinfo userinfo ;
    private ListView listView ;
    private static List<Userinfo> list ;
    private Button add_location ;
    private LocaAdapter locaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dizhi);
        add_location = (Button)findViewById(R.id.add_location) ;
        getData( ) ;

        listView = (ListView)findViewById(R.id.list_dizhi) ;

        locaAdapter = new LocaAdapter(DizhiActivity.this, list);
        listView.setAdapter(locaAdapter);

        // 点击添加新地址
        add_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DizhiActivity.this,AddLocationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        String a = getIntent().getStringExtra("p_name");
        String b = getIntent().getStringExtra("p_number");
        String c = getIntent().getStringExtra("p_location");
//
//        SharedPreferences sp = getSharedPreferences("p_info",MODE_PRIVATE) ;
//        String a = sp.getString("p_name","") ;
//        String b = sp.getString("p_number","" );
//        String c = sp.getString("p_location","") ;

        ToastUtil.showToast(DizhiActivity.this, a+" " +b +" " +c  );
        if(a!=null && b!=null &&c!=null) {

            ToastUtil.showToast(DizhiActivity.this, "添加成功");
            list.add(new Userinfo(a, b, c, R.drawable.default_user));
//            getData();
            locaAdapter.notifyDataSetChanged();
        }

    }

    public void getData() {
        list = new ArrayList<>() ;
        list.add(new Userinfo("郑*冲","18240****27","河南省郑州市中原区科学大道100号",R.drawable.default_user)) ;

        list.add(new Userinfo("郑*冲","18240****27","河南省郑州市中原区科学大道100号",R.drawable.default_user)) ;
    }
}
