package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itzheng.ZhengShopping.entity.Orders;
import com.itzheng.ZhengShopping.entity.User;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.PaidAdapter;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import ZhengShopping.R;

public class PaidActivity extends AppCompatActivity {

    ArrayList<Orders> Orderslist = null;

    String ordercode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid);

        Orderslist = new ArrayList<Orders>();

        MyApplication myApplication = (MyApplication) getApplication();

        String state = myApplication.getOrderstate();

        User user = myApplication.getUser();

        new Thread() {
            public void run() {

                int message = 0;

                if(Orderslist != null){
                    Orderslist.clear();
                }

                String data="";
                try {

                    data =  "method=findGoodsByUsercode&usercode="+user.getUsercode()+"&state="+state;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("OrderPhoneServlet",data);

                System.out.println(stuJson+"==============111111111111");

                try {

                    JSONArray jsonArray = new JSONArray(stuJson);

                    for(int i = 0;i < jsonArray.length();i++){

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        Orders orders = new Orders();
                        orders.setId(jsonObject.getInt("id"));
                        orders.setOrdercode(jsonObject.getString("ordercode"));
                        orders.setUsercode(jsonObject.getString("usercode"));
                        orders.setState(jsonObject.getString("state"));
                        orders.setDate(jsonObject.getString("date"));
                        orders.setPrice(jsonObject.getString("price"));
                        Orderslist.add(orders);

                    }

                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                for(Orders order :Orderslist){
                    System.out.println(order);
                }
                if(Orderslist.size() > 0){
                    message = 1;
                }

                hand.sendEmptyMessage(message);

            }
        }.start();
        ListView goodlist1 = (ListView) findViewById(R.id.unpaidlist);


        goodlist1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout lygoodcode = (LinearLayout)view;

                lygoodcode = (LinearLayout)lygoodcode.getChildAt(0);

                lygoodcode = (LinearLayout)lygoodcode.getChildAt(0);


                TextView textView1 = (TextView)lygoodcode.getChildAt(0);


                Toast.makeText(getApplicationContext(),textView1.getText()+":ordercode_order",Toast.LENGTH_LONG).show();

                ordercode = textView1.getText().toString()+"";



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
                Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                //  startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                for(Orders order :Orderslist){

                    System.out.println(order);

                }

                ListView goodlist = (ListView) findViewById(R.id.unpaidlist);

                PaidAdapter adapter = new PaidAdapter( Orderslist, getApplicationContext());

                goodlist.setAdapter(adapter);


            }


            if(msg.what == 3)
            {
                MyApplication myApplication = (MyApplication)getApplication();
                myApplication.setOrdercode(ordercode);
                startActivity(new Intent(getApplicationContext(),OrdersActivity.class));

            }





        }
    };

}