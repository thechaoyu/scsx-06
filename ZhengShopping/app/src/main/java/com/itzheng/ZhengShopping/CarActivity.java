package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.itzheng.ZhengShopping.entity.Car;
import com.itzheng.ZhengShopping.entity.Goods;
import com.itzheng.ZhengShopping.entity.User;
import com.itzheng.ZhengShopping.utils.CarAdapter;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ZhengShopping.R;

public class CarActivity extends AppCompatActivity {

    ArrayList<Car> carlist = null;
    String surl = "&";

    String ordercodeback = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);


        carlist = new  ArrayList<Car>();

        MyApplication myApplication = (MyApplication)getApplication();

        User user = myApplication.getUser();


        new Thread() {
            public void run() {

                int message = 0;

                if(carlist != null){
                    carlist.clear();
                }

                String data="";
                try {

                    data =  "method=findCars&usercode="+user.getUsercode();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("CarPhoneServlet",data);

                System.out.println(stuJson+"==============111111111111");

                try {

                    JSONArray jsonArray = new JSONArray(stuJson);

                    for(int i = 0;i < jsonArray.length();i++){

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                        Car car = new Car();

                        car.setId(jsonObject.getInt("id"));
                        car.setCarcode(jsonObject.getString("carcode"));
                        car.setUsercode(jsonObject.getString("usercode"));
                        car.setGoodcode(jsonObject.getString("goodcode"));
                        car.setGoodnumber(jsonObject.getString("goodnumber"));
                        car.setState(jsonObject.getString("state"));
                        car.setDate(jsonObject.getString("date"));

                        String gooarr = jsonObject.getString("goods");
                        System.out.println("arry"+gooarr);
                        JSONArray jsonArraygood = new JSONArray("["+gooarr+"]");

                        JSONObject jsonObjectgood = (JSONObject) jsonArraygood.get(0);
                        Goods goods = new Goods();
                        goods.setId(jsonObjectgood.getInt("id"));
                        goods.setGoodcode(jsonObjectgood.getString("goodcode"));
                        goods.setGoodname(jsonObjectgood.getString("goodname"));
                        goods.setGooddetail(jsonObjectgood.getString("gooddetail"));
                        goods.setGoodprice(jsonObjectgood.getString("goodprice"));
                        goods.setGooddiscount(jsonObjectgood.getString("gooddiscount"));
                        goods.setGoodstate(jsonObjectgood.getString("goodstate"));
                        goods.setGoodimagecode(jsonObjectgood.getString("goodimagecode"));
                        goods.setGoodstate(jsonObjectgood.getString("gooddate"));
                        goods.setGoodtypecode(jsonObjectgood.getString("goodtypecode"));
                        car.setGoods(goods);


                        carlist.add(car);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(carlist.size() > 0){
                    message = 1;

                }

                hand.sendEmptyMessage(message);
                for(Car car :carlist){
                    System.out.println(car);
                }
            }
        }.start();


    }

    public void shouye(View view){
        finish();
        //startActivity(new Intent(getApplicationContext(),AdminActivity.class));
        Intent it=new Intent();
        it.setClass(CarActivity.this,AdminActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void weitao(View view){

        //startActivity(new Intent(getApplicationContext(), WeitaoActivity.class));
        finish();
        Intent it=new Intent();
        it.setClass(CarActivity.this,WeitaoActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }
    public void xiaoxi(View view){

        //startActivity(new Intent(getApplicationContext(), XiaoxiActivity.class));
        finish();
        Intent it=new Intent();
        it.setClass(CarActivity.this,XiaoxiActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void wode(View view){
       // startActivity(new Intent(getApplicationContext(),MyMainActivity.class));
        finish();
        Intent it=new Intent();
        it.setClass(CarActivity.this,MyMainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void submitCal(View view){
        surl = "&";

        ListView  carlist = findViewById(R.id.carlist);

        CarAdapter carAdapter = (CarAdapter)carlist.getAdapter();

        int count = carAdapter.getCount();

        System.out.println(count);
        CheckBox checkBox[] = new CheckBox[count];

        ArrayList<Car> cars = new ArrayList<>();

        for(int i = 0; i < count;i++){

            checkBox[i] = (CheckBox)((LinearLayout) ( (LinearLayout)carlist.getChildAt(i)).getChildAt(0)).getChildAt(0);

            if(checkBox[i].isChecked()){
                System.out.println("---------------");
                Car car = new Car();
                //goodcode_car
                EditText number = (EditText)( (LinearLayout) ((LinearLayout) ( (LinearLayout)carlist.getChildAt(i)).getChildAt(0)).getChildAt(2)).getChildAt(2);
                TextView goodcode_car =(TextView) ( (LinearLayout) ((LinearLayout) ( (LinearLayout)carlist.getChildAt(i)).getChildAt(0)).getChildAt(2)).findViewById(R.id.goodcode_car);
                System.out.println(number.getText().toString());
                car.setGoodnumber(number.getText().toString());
                System.out.println(goodcode_car.getText().toString());
                car.setGoodcode(goodcode_car.getText().toString());

                MyApplication myApplication = (MyApplication)getApplication();

                User user = myApplication.getUser();

                car.setUsercode(user.getUsercode());

                cars.add(car);
            }

        }



        for(Car c :cars){
            System.out.println("order----"+c);
            surl += "usercode="+c.getUsercode()+"&goodcode="+c.getGoodcode()+"&goodnumber="+c.getGoodnumber()+"&";
        }


        new Thread() {
            public void run() {

                int message = 0;


                String data="";
                try {

                    data =  "method=addOrder" + surl;
                    System.out.println("data--------:"+data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String ordercode= PostUtil.Post("OrderPhoneServlet",data)+"";

                if(ordercode.length() > 1){
                    message = 2;
                    ordercodeback = ordercode;
                }
                hand.sendEmptyMessage(message);
            }
        }.start();




    }

    public void selectAll(View view){

        ListView  carlist = findViewById(R.id.carlist);

        CarAdapter carAdapter = (CarAdapter)carlist.getAdapter();

        int count = carAdapter.getCount();

        System.out.println(count);
        CheckBox checkBox[] = new CheckBox[count];

        boolean a = true;
        for(int i = 0; i < count;i++){

            checkBox[i] = (CheckBox)((LinearLayout) ( (LinearLayout)carlist.getChildAt(i)).getChildAt(0)).getChildAt(0);

            if(checkBox[i].isChecked()){
                checkBox[i].setChecked(false);
            }else{
                checkBox[i].setChecked(true);
            }

        }




    }

    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                //将数据放入到页面当中
                ListView goodlist = (ListView) findViewById(R.id.carlist);

                for(Car car:carlist){
                    System.out.println(car);
                    System.out.println(car.getGoods());
                }

                CarAdapter adapter = new CarAdapter( carlist, getApplicationContext());

                adapter.setAppCompatActivity( GetCarActivity());

                goodlist.setAdapter(adapter);

            }
            if(msg.what == 2){
                //跳转到订单页面
                startActivity(new Intent(getApplicationContext(),OrdersActivity.class));
                //ordercodeback
                MyApplication myApplication = (MyApplication)getApplication();

                myApplication.setOrdercode(ordercodeback);
            }

        }
    };
    public AppCompatActivity GetCarActivity(){
        return this;
    }
}