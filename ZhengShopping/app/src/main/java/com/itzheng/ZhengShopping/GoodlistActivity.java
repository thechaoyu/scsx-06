package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itzheng.ZhengShopping.entity.Goods;
import com.itzheng.ZhengShopping.entity.User;
import com.itzheng.ZhengShopping.utils.GoodListAdapter;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ZhengShopping.R;

public class GoodlistActivity extends AppCompatActivity {

    ArrayList<Goods> Goodsalist = null;
    String goodcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodlist);


        MyApplication myApplication = (MyApplication)getApplication();

        User user = myApplication.getUser();

        String goodtypecode =  myApplication.getGoodtypecode();

        String goodname = myApplication.getGoodname();

        EditText message = findViewById(R.id.message);

        message.setText(goodname);

        Goodsalist = new ArrayList<Goods>();

        System.out.println(goodname+"====================="+user);

        new Thread() {
            public void run() {

                int message = 0;

                if(Goodsalist != null){
                    Goodsalist.clear();
                }

                String data="";
                try {

                    data =  "method=findGoodsByGoodNameOrTypeId&goodtypecode="+goodtypecode+"&goodname="+goodname;
                    System.out.println(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("GoodsPhoneServlet",data);

                System.out.println(stuJson+"==============111111111111");

                try {

                    JSONArray jsonArray = new JSONArray(stuJson);

                    for(int i = 0;i < jsonArray.length();i++){

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        Goods goods = new Goods();
                        goods.setId(jsonObject.getInt("id"));
                        goods.setGoodcode(jsonObject.getString("goodcode"));
                        goods.setGoodname(jsonObject.getString("goodname"));
                        goods.setGooddetail(jsonObject.getString("gooddetail"));
                        goods.setGoodprice(jsonObject.getString("goodprice"));
                        goods.setGooddiscount(jsonObject.getString("gooddiscount"));
                        goods.setGoodstate(jsonObject.getString("goodstate"));
                        goods.setGoodimagecode(jsonObject.getString("goodimagecode"));
                        goods.setGoodstate(jsonObject.getString("gooddate"));
                        goods.setGoodtypecode(jsonObject.getString("goodtypecode"));

                        Goodsalist.add(goods);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(Goodsalist.size() > 0){
                    message = 1;
                }

                hand.sendEmptyMessage(message);
                for(Goods goods :Goodsalist){
                    System.out.println(goods);
                }
            }
        }.start();

        //设置点击ListView的事件

        ListView good_list_ly = findViewById(R.id.good_listlag);

        good_list_ly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout lygoodcode = (LinearLayout)view;

                lygoodcode = (LinearLayout)lygoodcode.getChildAt(0);

                lygoodcode = (LinearLayout)lygoodcode.getChildAt(1);

                TextView textView1 = (TextView)lygoodcode.getChildAt(3);


                Toast.makeText(getApplicationContext(),textView1.getText()+":goodcode",Toast.LENGTH_LONG).show();

                goodcode = textView1.getText().toString()+"";
                int message = 0;

                if(textView1.getText().toString() != null){
                    message = 3;
                }

                hand.sendEmptyMessage(message);

            }

        });

    }

    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)

            {
                for(Goods goods: Goodsalist){

                    System.out.println(goods);

                }

                ListView goodlist = (ListView) findViewById(R.id.good_listlag);

                GoodListAdapter adapter = new GoodListAdapter(Goodsalist, getApplicationContext());

                goodlist.setAdapter(adapter);

            }
            if(msg.what == 3)
            {
                //goodcode,查询详情

                MyApplication myApplication = (MyApplication)getApplication();

                myApplication.setGoodcode(goodcode);

                //跳转到商品详情页

                startActivity(new Intent(getApplicationContext(),GoodShowActivity.class));
            }

        }
    };
    public void search(View view){

        EditText message = findViewById(R.id.message);

        MyApplication myApplication = (MyApplication)getApplication();
        myApplication.setGoodname(message.getText().toString());
        myApplication.setGoodtypecode("");

        startActivity(new Intent(getApplicationContext(),GoodlistActivity.class));

    }

}