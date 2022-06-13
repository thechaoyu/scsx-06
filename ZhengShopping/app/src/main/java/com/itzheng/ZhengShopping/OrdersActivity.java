package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.itzheng.ZhengShopping.entity.Goods;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.OrderDetailListAdapter;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ZhengShopping.R;

public class OrdersActivity extends AppCompatActivity {

    ArrayList<Goods> goodlist = null;

    String ordercode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        goodlist = new  ArrayList<Goods>();
        MyApplication myApplication = (MyApplication)getApplication();

        ordercode = myApplication.getOrdercode();

        //查询出对应订单详情的商品

        new Thread() {
            public void run() {

                int message = 0;

                if(goodlist != null){
                    goodlist.clear();
                }

                String data="";
                try {

                    data =  "method=findOrders&ordercode="+ordercode;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("OrderPhoneServlet",data);

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
                        goods.setGooddate(jsonObject.getString("gooddate"));
                        goods.setGoodtypecode(jsonObject.getString("goodtypecode"));


                        goodlist.add(goods);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(goodlist.size() > 0){
                    message = 1;

                }

                hand.sendEmptyMessage(message);
                for(Goods goods :goodlist){
                    System.out.println(goods);
                }
            }
        }.start();




    }

    public void back(View view){
        startActivity(new Intent(getApplicationContext(),AdminActivity.class));
    }
    //more
    public void more(View view){
        startActivity(new Intent(getApplicationContext(),AdminActivity.class));
    }
    //submitOrder
    public void submitOrder(View view){

        //submitOrder
        if(ordercode.length() > 1){
            new Thread() {
                public void run() {

                    int message = 0;

                    if(goodlist != null){
                        goodlist.clear();
                    }

                    String data="";
                    try {

                        data =  "method=submitOrders&ordercode="+ordercode;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String stuJson= PostUtil.Post("OrderPhoneServlet",data);

                    System.out.println(stuJson+"==============111111111111");

                    if(stuJson.length() > 0){
                        message = 2;

                    }

                    hand.sendEmptyMessage(message);
                    for(Goods goods :goodlist){
                        System.out.println(goods);
                    }
                }
            }.start();


        }

    }
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                //将数据放入到页面当中
                ListView orderlist_act = (ListView) findViewById(R.id.orderlist_act);

                for(Goods goods:goodlist){
                    System.out.println(goods);
                }

                OrderDetailListAdapter adapter = new OrderDetailListAdapter( goodlist, getApplicationContext());

                adapter.setAppCompatActivity( getOrderActivity()  );

                orderlist_act.setAdapter(adapter);

            }

            if(msg.what == 2){

                startActivity(new Intent(getApplicationContext(),OrderSuccessActivity.class));

            }

        }
    };
    public AppCompatActivity getOrderActivity(){
        return this;
    }
}