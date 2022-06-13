package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.Adapter.ChatAdapter;
import com.itzheng.ZhengShopping.bean.ChatDate;
import com.itzheng.ZhengShopping.utils.xiaoxi;

import java.util.ArrayList;
import java.util.List;

import ZhengShopping.R;
public class XiaoxiActivity extends AppCompatActivity{
    TextView We_Tv1, We_Tv2, We_Tv3;
    ListView listView;
    List<ChatDate> listdate = new ArrayList<>();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiaoxifragment_chat);
        listView=(ListView)findViewById(R.id.listView_chat1);
        listdate.add(new ChatDate(R.drawable.qq1, "墨涵图书2群", "墨涵图书专营店:#墨涵今日上新#成功..", "7:40"));
        listdate.add(new ChatDate(R.drawable.qq2, "振国图书粉丝福利群4", "#考研高数18讲", "7:17"));
        listdate.add(new ChatDate(R.drawable.shudian1, "维多利亚优惠专享群", "请及时确认您的订单", "5:17"));
        listdate.add(new ChatDate(R.drawable.qq4, "菜鸟裹裹", "您的包裹已从代收点取出", "8:15"));
        listdate.add(new ChatDate(R.drawable.fuwu, "服务通知", "618购物券过期提醒", "9:30"));
        listdate.add(new ChatDate(R.drawable.shudian2, "四川新榜图书专卖店", "已经发货了", "9:28"));
        listdate.add(new ChatDate(R.drawable.suning, "天猫超市", "感谢关注天猫超市,每天享粉丝红包？", "9:46"));
        listdate.add(new ChatDate(R.drawable.taobaorensheng, "淘宝人生", "618结束拉~即将到...", "星期五"));
        listdate.add(new ChatDate(R.drawable.t9, "阿迪达斯官方旗舰店", "谢谢亲", "9:51"));
        ChatAdapter adapter=new ChatAdapter(XiaoxiActivity.this,listdate);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //startActivity(new Intent(getApplicationContext(), xiaoxi.class));
                Intent it=new Intent();
                it.setClass(XiaoxiActivity.this,xiaoxi.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(it);
            }
        });
    }

    public void shouye(View view){
        finish();
        Intent it=new Intent();
        it.setClass(XiaoxiActivity.this,AdminActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(), WeitaoActivity.class));
    }
    public void weitao(View view){
        finish();
        Intent it=new Intent();
        it.setClass(XiaoxiActivity.this,WeitaoActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(), WeitaoActivity.class));
    }

    public void gouwuche(View view){
        finish();
        Intent it=new Intent();
        it.setClass(XiaoxiActivity.this,CarActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(),CarActivity.class));
    }

    public void wode(View view){
        finish();
        Intent it=new Intent();
        it.setClass(XiaoxiActivity.this,MyMainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        //startActivity(new Intent(getApplicationContext(),MyMainActivity.class));

    }
}
