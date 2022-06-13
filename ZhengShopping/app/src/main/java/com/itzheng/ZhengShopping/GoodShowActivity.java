package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.itzheng.ZhengShopping.entity.Goods;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.MyImageView;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ZhengShopping.R;

public class GoodShowActivity extends AppCompatActivity {
    Goods goods = null;

    String ordercodeback = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_show);

        goods = new Goods();

        MyApplication myApplication = (MyApplication) getApplication();

        String goodcode11 = myApplication.getGoodcode();

        new Thread() {
            public void run() {

                int message = 0;


                String data="";
                try {

                    data =  "method=findGoodDetailBygoodcode&goodcode="+goodcode11;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("GoodsPhoneServlet",data);

                System.out.println(stuJson+"==============111111111111");

                try {

                    JSONArray jsonArray = new JSONArray(stuJson);

                    for(int i = 0;i < jsonArray.length();i++){

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);

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

                        String imagestring = jsonObject.getString("goodiamgecodearray");
                        System.out.println(imagestring+"!!!!!!!!!!!!!!-0-0-0-0-0-0-0-0-");
                        imagestring = StringUtils.strip(imagestring,"[]");
                        String[] stringarr  = imagestring.split(",");
                        goods.setGoodiamgecodearray(stringarr);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(goods != null){
                    message = 1;
                }

                hand.sendEmptyMessage(message);

            }
        }.start();





    }

    public void back(View view){
        startActivity(new Intent(getApplicationContext(),AdminActivity.class));
    }

    public void other(View view){
        startActivity(new Intent(getApplicationContext(),AdminActivity.class));
    }

    //more
    public void more(View view){
        startActivity(new Intent(getApplicationContext(),AdminActivity.class));
    }

    public void car(View view){
        startActivity(new Intent(getApplicationContext(),CarActivity.class));
    }
    //nowby
    public void nowby(View view){
        //立即购买
        TextView goodCode_ags =findViewById(R.id.goodCode_ags);
        MyApplication myApplication = (MyApplication)getApplication();

        String goodcode = goodCode_ags.getText().toString();

        String usercode = myApplication.getUser().getUsercode();

        String number = "1";

        new Thread() {
            public void run() {

                int message = 0;


                String data="";
                try {

                    data =  "method=addOrderBynow&goodcode=" + goodcode +"&usercode="+usercode+"&goodnumber="+number;
                    System.out.println("data--------:"+data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String ordercode= PostUtil.Post("OrderPhoneServlet",data)+"";

                if(ordercode.length() > 1){
                    message = 3;
                    ordercodeback = ordercode;
                }
                hand.sendEmptyMessage(message);
            }
        }.start();





    }

    public void addcar(View view){

        //获取当前商品的goodCode_ags
        TextView goodCode_ags =findViewById(R.id.goodCode_ags);

        MyApplication myApplication = (MyApplication)getApplication();

        String usercode = myApplication.getUser().getUsercode();

        String goodcode = goodCode_ags.getText().toString();

        System.out.println(goodcode+"==============");


        new Thread() {
            public void run() {

                int message = 0;

                String data="";
                try {

                    data =  "method=addCarByGoodcodeAndusercode&goodcode="+goodcode+"&usercode="+usercode;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("CarPhoneServlet",data);

                System.out.println(stuJson+"==============111111111111");

                if(stuJson.length()  > 1){
                    message = 2;
                }

                hand.sendEmptyMessage(message);

            }
        }.start();




    }

    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                //  startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                //将数据放入到页面当中
                System.out.println(goods+"==============");
                String[] s = goods.getGoodiamgecodearray();


                TextView price_ags = findViewById(R.id.price_ags);
                TextView detail_ags = findViewById(R.id.detail_ags);
                TextView goodCode_ags = findViewById(R.id.goodCode_ags);

                price_ags.setText(goods.getGoodprice());
                detail_ags.setText(goods.getGooddetail());
                goodCode_ags.setText(goods.getGoodcode());


              //  MyImageView myImageView = (MyImageView) findViewById(R.id.imagecenter);
              //  myImageView.setImageURL("http://10.0.2.2:8082/Zhengshop/image/upload/top.jpg");

                MyImageView myImageView1 = (MyImageView) findViewById(R.id.image1_ags);
                myImageView1.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+s[0].replace("\"", ""));

                System.out.println("http://10.0.2.2:8082/zhengshop/image/upload/good/"+s[0].replace("\"", ""));

                MyImageView myImageView2 = (MyImageView) findViewById(R.id.image2_ags);
                myImageView2.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+s[1].replace("\"", ""));

                MyImageView myImageView3 = (MyImageView) findViewById(R.id.image3_ags);
                myImageView3.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+s[2].replace("\"", ""));

                MyImageView myImageView4 = (MyImageView) findViewById(R.id.image4_ags);
                myImageView4.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+s[3].replace("\"", ""));

                MyImageView myImageView5 = (MyImageView) findViewById(R.id.image5_ags);
                myImageView5.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+s[4].replace("\"", ""));

            }
            if(msg.what == 2){
                Toast.makeText(getApplicationContext(),"添加成功",Toast.LENGTH_LONG).show();

            }
            if(msg.what == 3){
                //跳转到订单页面
                startActivity(new Intent(getApplicationContext(),OrdersActivity.class));
                //ordercodeback
                MyApplication myApplication = (MyApplication)getApplication();

                myApplication.setOrdercode(ordercodeback);
            }
        }
    };

}